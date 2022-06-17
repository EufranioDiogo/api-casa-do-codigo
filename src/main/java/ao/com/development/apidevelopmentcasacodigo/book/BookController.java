package ao.com.development.apidevelopmentcasacodigo.book;

import ao.com.development.apidevelopmentcasacodigo.book.author.AuthorRepository;
import ao.com.development.apidevelopmentcasacodigo.services.LocalUploaderSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class BookController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(new UniqueIsbnValidator(bookRepository), new UniqueBookTitle(bookRepository));
    }
    @Autowired
    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @PostMapping(value = "/api/book", consumes = "multipart/form-data")
    @Transactional
    public void createBook(@Valid BookForm newBookForm) {
        Book book = newBookForm.build(authorRepository, new LocalUploaderSpring());
        bookRepository.save(book);
    }
}
