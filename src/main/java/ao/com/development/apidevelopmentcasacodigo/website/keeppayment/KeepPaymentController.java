package ao.com.development.apidevelopmentcasacodigo.website.keeppayment;

import ao.com.development.apidevelopmentcasacodigo.book.BookRepository;
import ao.com.development.apidevelopmentcasacodigo.website.cart.BuyItem;
import ao.com.development.apidevelopmentcasacodigo.website.cart.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

@RestController
public class KeepPaymentController {
    private final BookRepository bookRepository;
    private final BuyRepository buyRepository;

    public KeepPaymentController(BookRepository bookRepository, BuyRepository buyRepository) {
        this.bookRepository = bookRepository;
        this.buyRepository = buyRepository;
    }

    @PostMapping(value = "/api/site/cart/next-step")
    @Transactional
    public String nextStepOfCart(@Valid @RequestBody BuyerData buyerData, @CookieValue("cart") Optional<String> cartJsonCookie) {
        Cart cart = Cart.generate(cartJsonCookie);

        Set<BuyItem> buyItems = cart.generateBuyItens(bookRepository);

        Buy newBuy = buyerData.newBuy(buyItems);

        buyRepository.save(newBuy);
        return newBuy.toString();
    }
}
