package ao.com.development.apidevelopmentcasacodigo.book.category;


import javax.validation.constraints.NotBlank;

public class CategoryForm {
    private @NotBlank String name;

    public String getName() {
        return name;
    }

    public CategoryForm setName(String name) {
        this.name = name;
        return this;
    }

    public Category build() {
        return new Category(name);
    }
}
