package ao.com.development.apidevelopmentcasacodigo.website.book.details;

import ao.com.development.apidevelopmentcasacodigo.book.Book;
import ao.com.development.apidevelopmentcasacodigo.book.BookRepository;
import ao.com.development.apidevelopmentcasacodigo.shared.Cookies;
import ao.com.development.apidevelopmentcasacodigo.website.cart.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
public class BookDetailsController {

    private final BookRepository bookRepository;

    @Autowired
    public BookDetailsController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(value = "/api/site/book/{id}")
    public BookDetail getBookDetail(@PathParam(value = "id") Long bookId) {
        Optional<Book> book = bookRepository.findByPkBook(bookId);

        book.orElseThrow();

        return new BookDetail(book.get());
    }
}
