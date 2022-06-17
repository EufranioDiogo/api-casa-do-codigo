package ao.com.development.apidevelopmentcasacodigo.book.author;

import ao.com.development.apidevelopmentcasacodigo.book.Book;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkAuthor;
    private @NotBlank String name;
    private @NotBlank @URL String githubLink;
    private String about;
    private @PastOrPresent final LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "author")
    private List<Book> authorBooks;


    @Deprecated
    public Author() {
    }

    public Author(@NotBlank String name, @NotBlank @URL String githubLink, String about, List<Book> authorBooks) {
        this.name = name;
        this.githubLink = githubLink;
        this.about = about;
        this.authorBooks = authorBooks;
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
}
