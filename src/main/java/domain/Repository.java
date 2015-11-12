package domain;

import java.util.List;

public interface Repository {
    void save(Post... posts);

    List<Post> readAll();

    Post read(String title);
}
