package blog.domain;

public class Post {

    private String title;
    private String text;

    public Post(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object obj) {
        Post post = (Post)obj;
        return title.equals(post.title) && text.equals(post.text);
    }

    @Override
    public String toString() {
        return title + " " + text;
    }
}
