package ao.com.development.apidevelopmentcasacodigo.website.book.details;


import ao.com.development.apidevelopmentcasacodigo.book.Book;
import ao.com.development.apidevelopmentcasacodigo.book.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

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

    public void setBooksOnCart(NavigableSet<BookForCart> booksOnCart) {
        this.booksOnCart = booksOnCart;
    }

    /**
     *
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
}
