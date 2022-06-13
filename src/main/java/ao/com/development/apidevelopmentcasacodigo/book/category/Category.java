package ao.com.development.apidevelopmentcasacodigo.book.category;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private @NotBlank String name;
    private @PastOrPresent final LocalDateTime createdAt = LocalDateTime.now();

    public Category(@NotBlank String name) {
        this.name = name;
    }

    @Deprecated
    public Category() {

    }
}
