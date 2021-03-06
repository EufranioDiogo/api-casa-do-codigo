package ao.com.development.apidevelopmentcasacodigo.website.cart;

import ao.com.development.apidevelopmentcasacodigo.book.Book;
import ao.com.development.apidevelopmentcasacodigo.book.BookRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.util.Assert;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookForCart implements Comparable<BookForCart> {
    private Long bookId;
    private String bookCoverImage;
    private String bookTitle;
    private BigDecimal bookPrice;
    private BigDecimal saledPrice;
    private Long quantity = 1L;

    public BookForCart() {
    }


    public BookForCart(Book book) {
        this.bookId = book.getPkBook();
        this.bookCoverImage = book.getCoverImageLink();
        this.bookTitle = book.getTitle();
        this.bookPrice = book.getBookPrice();
        this.saledPrice = bookPrice;
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

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return this.bookPrice.multiply(BigDecimal.valueOf(this.quantity));
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    public BigDecimal getSaledPrice() {
        return saledPrice;
    }

    public void setSaledPrice(BigDecimal saledPrice) {
        this.saledPrice = saledPrice;
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

    public void decrease(Long quantityToDecrease) {
        Assert.isTrue(quantityToDecrease <= this.quantity, "The quantity that you want to reduce " +
                "must be equal or less than actual quantity");
        this.quantity -= quantityToDecrease;
    }
    public BuyItem generateBuyItem(BookRepository bookRepository) {
        Book book = bookRepository.findByPkBook(this.bookId).get();
        return new BuyItem(book, this.bookTitle, this.bookPrice, this.quantity, this.getTotal(), this.saledPrice);
    }
}
