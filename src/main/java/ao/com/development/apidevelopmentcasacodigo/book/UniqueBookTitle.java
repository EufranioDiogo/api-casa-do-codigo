package ao.com.development.apidevelopmentcasacodigo.book;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class UniqueBookTitle extends UniqueFieldBookValidator {
    private BookRepository bookRepository;

    public UniqueBookTitle(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Book> searchBook(BookForm bookForm) {
        String titleOfBook = bookForm.getTitle();

        Optional<Book> bookRetrieved = bookRepository.findByTitle(titleOfBook);

        return bookRetrieved;
    }

    @Override
    protected String getFieldName() {
        return "isbn";
    }
}
