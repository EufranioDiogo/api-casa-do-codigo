package ao.com.development.apidevelopmentcasacodigo.website.home;

import ao.com.development.apidevelopmentcasacodigo.book.Book;
import ao.com.development.apidevelopmentcasacodigo.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@RestController
public class HomeController {

    private final BookRepository bookRepository;

    @Autowired
    public HomeController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(value = "/api/site/home")
    public List<BookForHome> getAllHomeBooks() {
        return bookRepository
                .findAll()
                .stream()
                .map(BookForHome::new)
                .collect(Collectors.toList());
    }
}
