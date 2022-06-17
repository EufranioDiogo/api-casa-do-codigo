package ao.com.development.apidevelopmentcasacodigo.book;

import ao.com.development.apidevelopmentcasacodigo.book.author.Author;
import ao.com.development.apidevelopmentcasacodigo.book.author.AuthorRepository;
import ao.com.development.apidevelopmentcasacodigo.services.Uploader;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.Option;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Optional;

public class BookForm {
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
    @NotNull
    private MultipartFile coverImage;
    @NotNull
    private Long fkAuthor;


    public Book  build(AuthorRepository authorRepository, Uploader uploader) {
        Optional<Author> authorOfTheBook = authorRepository.findById(fkAuthor);

        authorOfTheBook.orElseThrow();

        String resultedCoverImage = uploader.upload(this.coverImage);

        return new Book(title, subtitle, bookPrice, summary, content, numberOfPages, isbn, authorOfTheBook.get(), resultedCoverImage);
    }

    public String getTitle() {
        return title;
    }

    public BookForm setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public BookForm setSubtitle(String subtitle) {
        this.subtitle = subtitle;
        return this;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public BookForm setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public BookForm setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public String getContent() {
        return content;
    }

    public BookForm setContent(String content) {
        this.content = content;
        return this;
    }

    public Long getNumberOfPages() {
        return numberOfPages;
    }

    public BookForm setNumberOfPages(Long numberOfPages) {
        this.numberOfPages = numberOfPages;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookForm setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public MultipartFile getCoverImage() {
        return coverImage;
    }

    public BookForm setCoverImage(MultipartFile coverImage) {
        this.coverImage = coverImage;
        return this;
    }

    public Long getFkAuthor() {
        return fkAuthor;
    }

    public BookForm setFkAuthor(Long fkAuthor) {
        this.fkAuthor = fkAuthor;
        return this;
    }
}
