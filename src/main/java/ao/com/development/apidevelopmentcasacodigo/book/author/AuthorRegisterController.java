package ao.com.development.apidevelopmentcasacodigo.book.author;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class AuthorRegisterController {

    private final AuthorRepository authorRepository;

    public AuthorRegisterController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping(value = "/api/autor")
    @Transactional
    public void createNewAuthor(@Valid @RequestBody  NewAuthorForm newAuthorForm){
        Author newAuthor = newAuthorForm.build();

        authorRepository.save(newAuthor);
    }
}
