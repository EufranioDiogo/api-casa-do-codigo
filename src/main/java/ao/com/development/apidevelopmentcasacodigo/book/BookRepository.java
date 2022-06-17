package ao.com.development.apidevelopmentcasacodigo.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbnOfBook);

    Optional<Book> findByTitle(String isbnOfBook);
}