package domain;

import java.util.Date;

public class Post {

    private String author;
    private String title;
    private Date date;

    public Post(String author, String title, Date date) {
        this.author = author;
        this.title = title;
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }
}
