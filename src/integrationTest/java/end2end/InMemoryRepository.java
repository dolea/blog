package end2end;

import blog.domain.Post;
import blog.domain.Repository;

import java.util.List;

import static java.util.Arrays.asList;

public class InMemoryRepository implements Repository {
    private List<Post> posts;

    @Override
    public void save(Post... posts) {
        this.posts = asList(posts);
    }

    @Override
    public List<Post> readAll() {
        return posts;
    }

    @Override
    public Post read(String title) {
        return posts.stream().filter(post -> post.getTitle().equals(title)).findFirst().get();
    }
}
