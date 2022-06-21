package ao.com.development.apidevelopmentcasacodigo.website.keeppayment;

import ao.com.development.apidevelopmentcasacodigo.book.BookRepository;
import ao.com.development.apidevelopmentcasacodigo.cupom.Cupom;
import ao.com.development.apidevelopmentcasacodigo.cupom.CupomRepository;
import ao.com.development.apidevelopmentcasacodigo.shared.Cookies;
import ao.com.development.apidevelopmentcasacodigo.website.cart.BuyItem;
import ao.com.development.apidevelopmentcasacodigo.website.cart.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

@RestController
public class KeepPaymentController {
    private final BookRepository bookRepository;
    private final BuyRepository buyRepository;
    private final CupomRepository cupomRepository;

    public KeepPaymentController(BookRepository bookRepository, BuyRepository buyRepository, CupomRepository cupomRepository) {
        this.bookRepository = bookRepository;
        this.buyRepository = buyRepository;
        this.cupomRepository = cupomRepository;
    }

    @PostMapping(value = "/api/site/cart/next-step")
    @Transactional
    public String nextStepOfCart(@Valid @RequestBody BuyForm buyForm, @CookieValue("cart") Optional<String> cartJsonCookie, HttpServletResponse response) {
        Optional<Cupom> cupom = buyForm.getCupom(cupomRepository);
        Cart cart = Cart.generate(cartJsonCookie);

        Set<BuyItem> buyItems = cart.generateBuyItens(bookRepository, cupom);

        Buy newBuy = buyForm.buildBuyerData().newBuy(buyItems, cupom);

        buyRepository.save(newBuy);

        Cookies cookies = new Cookies();

        cookies.writeToWithJSON("cart", new Cart(), response);

        return newBuy.toString();
    }
}
