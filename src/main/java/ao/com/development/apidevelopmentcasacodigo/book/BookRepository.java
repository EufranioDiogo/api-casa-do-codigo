package ao.com.development.apidevelopmentcasacodigo.book;

import ao.com.development.apidevelopmentcasacodigo.website.book.details.BookDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface  BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbnOfBook);

    Optional<Book> findByTitle(String isbnOfBook);

    Optional<Book> findByPkBook(Long bookId);
}