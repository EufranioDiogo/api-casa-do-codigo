package ao.com.development.apidevelopmentcasacodigo.book;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class UniqueIsbnValidator implements Validator {
    private BookRepository bookRepository;

    public UniqueIsbnValidator(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return BookForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BookForm bookForm = (BookForm) target;
        String isbnOfBook = bookForm.getIsbn();

        Optional<Book> bookRetrieved = bookRepository.findByIsbn(isbnOfBook);

        if (bookRetrieved.isPresent()) {
            errors.rejectValue("isbn", null, "Já existe um livro com esse isbn");
        }
    }
}
