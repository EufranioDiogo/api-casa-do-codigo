package ao.com.development.apidevelopmentcasacodigo.book;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class UniqueIsbnValidator extends UniqueFieldBookValidator {
    private final BookRepository bookRepository;

    public UniqueIsbnValidator(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Book> searchBook(BookForm bookForm) {
        String isbnOfBook = bookForm.getIsbn();

        Optional<Book> bookRetrieved = bookRepository.findByIsbn(isbnOfBook);

        return bookRetrieved;
    }

    @Override
    protected String getFieldName() {
        return "isbn";
    }
}
