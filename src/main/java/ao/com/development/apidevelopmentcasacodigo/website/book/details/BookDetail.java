package ao.com.development.apidevelopmentcasacodigo.website.book.details;

import ao.com.development.apidevelopmentcasacodigo.book.Book;
import ao.com.development.apidevelopmentcasacodigo.shared.configuration.Markdown;

import java.math.BigDecimal;

public class BookDetail {
    private final Long bookId;
    private final String title;
    private final String coverImage;
    private final BigDecimal price;
    private final String content;
    private final String originalTopicsMarkDown;
    private final Long bookPages;
    private final String isb;
    private final AuthorForBookDetail authorForBookDetail;
    private final String originalTopicsHTML;

    public BookDetail(Book book) {
        this.bookId = book.getPkBook();
        this.title = book.getTitle();
        this.coverImage = book.getCoverImageLink();
        this.price = book.getBookPrice();
        this.content = book.getContent();
        this.originalTopicsMarkDown = book.getSummary();
        this.originalTopicsHTML = Markdown.toHtml(this.originalTopicsMarkDown);
        this.bookPages = book.getNumberOfPages();
        this.isb = book.getIsbn();
        this.authorForBookDetail = new AuthorForBookDetail(book.getAuthor());
    }


    public Long getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getContent() {
        return content;
    }

    public String getOriginalTopicsMarkDown() {
        return originalTopicsMarkDown;
    }

    public Long getBookPages() {
        return bookPages;
    }

    public String getIsb() {
        return isb;
    }

    public AuthorForBookDetail getAuthorForBookDetail() {
        return authorForBookDetail;
    }

    public String getOriginalTopicsHTML() {
        return originalTopicsHTML;
    }
}
