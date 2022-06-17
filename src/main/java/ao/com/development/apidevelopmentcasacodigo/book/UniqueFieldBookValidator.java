package ao.com.development.apidevelopmentcasacodigo.book;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public abstract  class UniqueFieldBookValidator implements Validator  {

    public abstract Optional<Book> searchBook(BookForm bookForm);

    @Override
    public boolean supports(Class<?> clazz) {
        return BookForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BookForm bookForm = (BookForm) target;

        Optional<Book> bookRetrieved = searchBook(bookForm);

        if (bookRetrieved.isPresent()) {
            String fieldName = getFieldName();
            errors.rejectValue(fieldName,
                    null,
                    "Já existe um livro com esse isbn");
        }
    }

    protected abstract String getFieldName();


}
