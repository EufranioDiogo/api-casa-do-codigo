package ao.com.development.apidevelopmentcasacodigo.website.book.details;

import ao.com.development.apidevelopmentcasacodigo.book.Book;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Transient;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookForCart implements Comparable<BookForCart> {
    private Long bookId;
    private String bookCoverImage;
    private String bookTitle;
    private BigDecimal bookPrice;
    private Long quantity = 1L;

    public BookForCart() {
    }


    public BookForCart(Book book) {
        this.bookId = book.getPkBook();
        this.bookCoverImage = book.getCoverImageLink();
        this.bookTitle = book.getTitle();
        this.bookPrice = book.getBookPrice();
        this.quantity = 1L;
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

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public BigDecimal getTotal() {
        return this.bookPrice.multiply(BigDecimal.valueOf(this.quantity));
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

    public void increment() {
        if (this.quantity == null) {
            this.quantity = 1L;
        }

        this.quantity++;
    }
}
