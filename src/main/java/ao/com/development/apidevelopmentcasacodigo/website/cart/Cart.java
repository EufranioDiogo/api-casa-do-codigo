package ao.com.development.apidevelopmentcasacodigo.website.cart;


import ao.com.development.apidevelopmentcasacodigo.book.Book;
import ao.com.development.apidevelopmentcasacodigo.book.BookRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.Assert;

import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cart {
    private NavigableSet<BookForCart> booksOnCart = new TreeSet<>();

    public Cart() {
    }

    public Cart(NavigableSet<BookForCart> booksOnCart) {
        this.booksOnCart = booksOnCart;
    }


    private void addBookForCart(BookForCart bookForCart) {
        boolean isBookNotInserted = this.booksOnCart.add(bookForCart);

        if (!isBookNotInserted) {
            BookForCart bookForCart1 = this.booksOnCart.stream().filter(book -> book.equals(bookForCart)).findFirst().get();
            bookForCart1.increment();
        }
    }

    public NavigableSet<BookForCart> getBooksOnCart() {
        return booksOnCart;
    }

    public BigDecimal getCartTotal() {
        return this.booksOnCart
                .stream()
                .map(BookForCart::getTotal)
                .reduce(
                    BigDecimal.ZERO, BigDecimal::add
                );
    }

    public void setBooksOnCart(NavigableSet<BookForCart> booksOnCart) {
        this.booksOnCart = booksOnCart;
    }

    /**
     * @param s is the json retrieved by cookie cart
     * @return is a new or existing cart in the cookie sended
     */
    private static Cart createCart(String s) {
        try {
            return new ObjectMapper().readValue(s, Cart.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new Cart();
    }


    public static Cart generate(Optional<String> s) {
        return s.map(Cart::createCart).orElse(new Cart());
    }

    public void addBook(Long bookId, BookRepository bookRepository) {
        Optional<Book> book = bookRepository.findByPkBook(bookId);
        book.orElseThrow();

        this.addBookForCart(new BookForCart(book.get()));
    }

    public boolean removeBook(Long bookId) {
        BookForCart bookForCart = new BookForCart();
        bookForCart.setBookId(bookId);

        return this.booksOnCart.remove(bookForCart);
    }

    public void updateBook(Long bookId, @Positive Long quantity) {
        Assert.isTrue(quantity >= 0, "Quantity to decrease must be positive and not 0");
        BookForCart auxBookForCart = new BookForCart();

        auxBookForCart.setBookId(bookId);
        if (!this.booksOnCart.contains(auxBookForCart)) {
            return;
        }

        BookForCart bookForCart = this.booksOnCart
                .stream()
                .filter(auxBookForCart::equals)
                .findFirst()
                .get();

        if (quantity.equals(bookForCart.getQuantity())) {
            this.booksOnCart.remove(bookForCart);
            return;
        }
        bookForCart.decrease(quantity);
    }
}
