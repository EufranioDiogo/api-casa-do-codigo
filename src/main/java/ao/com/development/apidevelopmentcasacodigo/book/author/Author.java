package ao.com.development.apidevelopmentcasacodigo.book.author;

import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotBlank String name;
    private @NotBlank @URL String githubLink;
    private String about;
    private @PastOrPresent final LocalDateTime createdAt = LocalDateTime.now();

    public Author(@NotBlank String name, @NotBlank @URL String githubLink, String about) {
        this.name = name;
        this.githubLink = githubLink;
    }
    public Author(@NotBlank String name, @NotBlank @URL String githubLink) {
        this.name = name;
        this.githubLink = githubLink;
    }


    public Author() {

    }
}
