package ao.com.development.apidevelopmentcasacodigo.website.cart;

import ao.com.development.apidevelopmentcasacodigo.book.Book;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Optional;

@Embeddable
public class BuyItem {
    @ManyToOne
    private Book book;
    private String title;
    private BigDecimal price;
    private Long quantity;
    private BigDecimal total;

    public BuyItem(Book book, String title , BigDecimal bookPrice, Long quantity, BigDecimal total) {
        this.book = book;
        this.title = title;
        this.price = bookPrice;
        this.quantity = quantity;
        this.total = total;
    }

    public BuyItem() {

    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BuyItem buyItem = (BuyItem) o;

        if (this.book == null || buyItem.book == null)
            return false;

        return book.getPkBook().equals(buyItem.book.getPkBook());
    }

    @Override
    public int hashCode() {
        return book != null ? book.getPkBook().hashCode() : 0;
    }
}
