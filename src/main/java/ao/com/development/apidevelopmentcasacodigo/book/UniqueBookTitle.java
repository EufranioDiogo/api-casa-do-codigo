package ao.com.development.apidevelopmentcasacodigo.book;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class UniqueBookTitle implements Validator {
    private BookRepository bookRepository;

    public UniqueBookTitle(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return BookForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BookForm bookForm = (BookForm) target;
        String bookTitle = bookForm.getTitle();

        Optional<Book> bookRetrieved = bookRepository.findByTitle(bookTitle);

        if (bookRetrieved.isPresent()) {
            errors.rejectValue("title", null, "Já existe um livro com esse titulo");
        }
    }
}
