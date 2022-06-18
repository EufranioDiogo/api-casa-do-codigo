package ao.com.development.apidevelopmentcasacodigo.shared;

import ao.com.development.apidevelopmentcasacodigo.website.cart.Cart;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Component
public class Cookies {
    public void writeToWithJSON(String paramName, Cart cart, HttpServletResponse response) {
        Cookie newCartCookie = null;
        try {
            newCartCookie = new Cookie("cart", new ObjectMapper().writeValueAsString(cart));
            newCartCookie.setHttpOnly(true);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        response.addCookie(newCartCookie);
    }
}
