package ao.com.development.apidevelopmentcasacodigo.website.book.details;

import ao.com.development.apidevelopmentcasacodigo.book.Book;
import ao.com.development.apidevelopmentcasacodigo.book.BookRepository;
import ao.com.development.apidevelopmentcasacodigo.shared.Cookies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
public class BookDetailsController {

    private final BookRepository bookRepository;
    private final Cookies cookies;

    @Autowired
    public BookDetailsController(BookRepository bookRepository, Cookies cookies) {
        this.bookRepository = bookRepository;
        this.cookies = cookies;
    }

    @GetMapping(value = "/api/site/book/{id}")
    public BookDetail getBookDetail(@PathParam(value = "id") Long bookId) {
        Optional<Book> book = bookRepository.findByPkBook(bookId);

        book.orElseThrow();

        return new BookDetail(book.get());
    }

    @PostMapping(value = "/api/site/cart/{id}")
    public Cart addBookToCart(@PathVariable(value = "id") Long bookId, @CookieValue("cart") Optional<String> jsonCart, HttpServletResponse response) {
        /*
         * add the book to cart
         *
         * Add book to cookie(json)
         * If doesn't have a cookie for that client, create a new one
         * and add book to it
         * If the user has a cart cookie already
         * add the book to cart
         *
         * book in cart is view as (cover_image, title, price)
         */
        Cart cart = Cart.generate(jsonCart);

        cart.addBook(bookId, bookRepository);

        cookies.writeToWithJSON("paramName", cart, response);

        return cart;
    }

    @DeleteMapping(value = "/api/site/cart/{id}")
    public Cart removeBookToCart(@PathVariable(value = "id") Long bookId, @CookieValue("cart") Optional<String> jsonCart, HttpServletResponse response) {
        Cart cart = Cart.generate(jsonCart);

        cart.removeBook(bookId);

        cookies.writeToWithJSON("paramName", cart, response);

        return cart;
    }
}
