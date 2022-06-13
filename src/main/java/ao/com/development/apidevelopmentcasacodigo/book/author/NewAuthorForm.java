package ao.com.development.apidevelopmentcasacodigo.book.author;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

public class NewAuthorForm {
    @NotBlank
    private String name;
    @URL
    @NotBlank
    private String githubLink;
    private String about;

    public String getName() {
        return name;
    }

    public NewAuthorForm setName(String name) {
        this.name = name;
        return this;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public NewAuthorForm setGithubLink(String githubLink) {
        this.githubLink = githubLink;
        return this;
    }

    public Author build() {
        return new Author(name, githubLink, about);
    }
}
