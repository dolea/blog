package infrastructure;

import domain.Post;

import java.util.List;

public class RestManager {

    Repository repo;

    public RestManager(Repository repo) {
        this.repo = repo;
    }

    public static List<Post> getPosts() {
        return null;
    }
}
