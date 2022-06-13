package ao.com.development.apidevelopmentcasacodigo.book.category;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class WithoutCategoryWithDuplicatedName implements Validator {
    private final CategoryRepository categoryRepository;

    public WithoutCategoryWithDuplicatedName(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoryForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CategoryForm categoryForm = (CategoryForm) target;

        Optional<Category> category = categoryRepository.findByName(categoryForm.getName());

        category
                .ifPresent(category1 -> errors.reject("name", null, "The Category already exists"));
    }
}
