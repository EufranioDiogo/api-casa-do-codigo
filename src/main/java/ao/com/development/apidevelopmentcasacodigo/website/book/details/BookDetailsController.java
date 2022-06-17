package ao.com.development.apidevelopmentcasacodigo.website.book.details;

import ao.com.development.apidevelopmentcasacodigo.book.Book;
import ao.com.development.apidevelopmentcasacodigo.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Collection;
import java.util.Optional;

@RestController
public class BookDetailsController {

    private BookRepository bookRepository;

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
