package ao.com.development.apidevelopmentcasacodigo.book;

import ao.com.development.apidevelopmentcasacodigo.book.author.Author;
import org.hibernate.validator.constraints.URL;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkBook;
    @Size(max = 100)
    @NotBlank
    private  String title;
    @Size(max = 50)
    @NotBlank
    private String subtitle;
    @Min(0)
    private BigDecimal bookPrice;
    @NotBlank
    private String summary;
    @NotBlank
    private String content;
    @Min(value = 100)
    private Long numberOfPages;
    @NotBlank
    private String isbn;
    @NotBlank
    @URL
    private String coverImageLink;
    @ManyToOne
    @JoinColumn(name = "fk_author")
    @NotNull
    private Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book(@NotBlank @Size(max = 100) String title,
                @NotBlank @Size(max = 50) String subtitle,
                @Min(0) BigDecimal bookPrice,
                @NotBlank String summary,
                @NotBlank String content,
                @Min(100) Long numberOfPages,
                @NotBlank String isbn,
                @NotNull Author author,
                @NotBlank @URL String coverImageLink
    ) {
        this.title = title;
        this.subtitle = subtitle;
        this.bookPrice = bookPrice;
        this.summary = summary;
        this.content = content;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.coverImageLink = coverImageLink;
        this.author = author;
    }

    public Book() {

    }


    public Long getPkBook() {
        return pkBook;
    }

    public void setPkBook(Long pkBook) {
        this.pkBook = pkBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Long numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCoverImageLink() {
        return coverImageLink;
    }

    public void setCoverImageLink(String coverImageLink) {
        this.coverImageLink = coverImageLink;
    }
}
