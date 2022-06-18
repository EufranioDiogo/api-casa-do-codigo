package ao.com.development.apidevelopmentcasacodigo.website.book.details;

import ao.com.development.apidevelopmentcasacodigo.book.Book;

import java.math.BigDecimal;

public class BookForCart implements Comparable<BookForCart> {
    private Long bookId;
    private String bookCoverImage;
    private String bookTitle;
    private BigDecimal bookPrice;

    public BookForCart() {
    }

    public BookForCart(Book book) {
        this.bookId = book.getPkBook();
        this.bookCoverImage = book.getCoverImageLink();
        this.bookTitle = book.getTitle();
        this.bookPrice = book.getBookPrice();
    }

    public Long getBookId() {
        return bookId;
    }

    public String getBookCoverImage() {
        return bookCoverImage;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookForCart that = (BookForCart) o;

        return bookId.equals(that.bookId);
    }

    @Override
    public int hashCode() {
        return bookId.hashCode();
    }

    @Override
    public int compareTo(BookForCart o) {
        return bookId.compareTo(o.getBookId());
    }
}
