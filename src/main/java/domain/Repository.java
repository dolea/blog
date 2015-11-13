package domain;

import java.io.IOException;
import java.util.List;

public interface Repository {
    void save(Post... posts) throws IOException;

    List<Post> readAll() throws IOException;

    Post read(String title) throws IOException;
}
