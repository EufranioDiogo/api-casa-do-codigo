package ao.com.development.apidevelopmentcasacodigo.website.home;

import ao.com.development.apidevelopmentcasacodigo.book.Book;

import java.math.BigDecimal;

public class BookForHome {
    private final Book book;

    public BookForHome(Book book) {
        this.book = book;
    }

    public String getTitle() {
        return this.book.getTitle();
    }

    public BigDecimal getPrice() {
        return this.book.getBookPrice();
    }

    public String getAuthorName() {
        return this.book.getAuthor().getName();
    }
}
