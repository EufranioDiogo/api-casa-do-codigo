package ao.com.development.apidevelopmentcasacodigo.website.book.details;

import ao.com.development.apidevelopmentcasacodigo.book.author.Author;

public class AuthorForBookDetail {

    private final String name;
    private final String about;
    private final String github;

    public AuthorForBookDetail(Author author) {
        this.name = author.getName();
        this.about = author.getAbout();
        this.github = author.getGithubLink();
    }

    public String getName() {
        return name;
    }

    public String getAbout() {
        return about;
    }

    public String getGithub() {
        return github;
    }
}
