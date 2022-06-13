package ao.com.development.apidevelopmentcasacodigo.book.category;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CategoryController {
    private final CategoryRepository categoryRepository;

    @InitBinder("categoryForm")
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(new WithoutCategoryWithDuplicatedName(categoryRepository));
    }

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping("/api/book/category")
    @Transactional
    public void createBookCategory(@Valid @RequestBody CategoryForm categoryForm) {
        Category category = categoryForm.build();
        categoryRepository.save(category);
    }
}
