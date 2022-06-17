package ao.com.development.apidevelopmentcasacodigo.book.author;

import ao.com.development.apidevelopmentcasacodigo.book.Book;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkAuthor;
    private @NotBlank String name;
    private @NotBlank @URL String githubLink;
    private String about;
    private @PastOrPresent final LocalDateTime createdAt = LocalDateTime.now();


    @Deprecated
    public Author() {
    }

    public Author(@NotBlank String name, @NotBlank @URL String githubLink, String about) {
        this.name = name;
        this.githubLink = githubLink;
        this.about = about;
    }
    public Author(@NotBlank String name, @NotBlank @URL String githubLink) {
        this.name = name;
        this.githubLink = githubLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPkAuthor() {
        return pkAuthor;
    }

    public void setPkAuthor(Long pkAuthor) {
        this.pkAuthor = pkAuthor;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
