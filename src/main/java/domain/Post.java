package domain;

import java.util.Date;

public class Post {

    private String author;
    private String title;
    private Date date;
    private String body;

    public Post(String author, String title, Date date, String body) {
        this.author = author;
        this.title = title;
        this.date = date;
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public String getBody() {
        return body;
    }
}
