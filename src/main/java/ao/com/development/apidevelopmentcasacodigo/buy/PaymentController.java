package ao.com.development.apidevelopmentcasacodigo.buy;

import ao.com.development.apidevelopmentcasacodigo.website.keeppayment.Buy;
import ao.com.development.apidevelopmentcasacodigo.website.keeppayment.BuyRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
public class PaymentController {
    private final BuyRepository buyRepository;
    private final PaymentRepository paymentRepository;

    public PaymentController(BuyRepository buyRepository, PaymentRepository paymentRepository) {
        this.buyRepository = buyRepository;
        this.paymentRepository = paymentRepository;
    }

    @PostMapping(value = "/api/payment/{buyId}")
    @Transactional
    public void creatingBuyOrder(@PathVariable Long buyId, @Valid  @RequestBody PaypalForm paypalResponse) {
        Optional<Buy> buyOrder = buyRepository.findById(buyId);

        buyOrder.orElseThrow();

        PaypalPayment paypalPayment = paypalResponse.newPaypalPayment(buyOrder.get());


        paymentRepository.save(paypalPayment);

        if (paypalPayment.isValid()) {
            EmailsCentral.sendGoodMailToAdmin(paypalPayment);
            EmailsCentral.sendGoodMailToClient(paypalPayment);
        } else {
            EmailsCentral.sendBadMailToAdmin(paypalPayment);
        }
    }
}
