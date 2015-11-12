package infrastructure;

import domain.Post;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.StandardOpenOption;

public class RepositoryTest {

    private Repository repo;

    @Before
    public void initialize() {
        repo = new Repository(
                "./test_repo.txt",
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING
        );
    }

    @Test
    public void save_GivenAPost_WhenSaved_ThenPostIdShouldReturn() {
        String title = "Lorem";
        Post post = new Post(title, "Sit");
        String id = repo.save(post);

        Assert.assertThat(id, Matchers.equalTo(title));
    }

    @Test
    public void read_GivenATitleNotStored_WhenReadById_ThenShouldReturnNull() {
        Assert.assertNull(repo.read("invalid"));
    }

    @Test
    public void read_GivenATitleStored_WhenReadByPostId_ThenShouldReturnPost() {
        String title = "Dolor";
        Post post = new Post(title, "Sit");
        repo.save(post);

        Assert.assertThat(repo.read(title), Matchers.equalTo(post));
    }

    @Test
    public void readAll_GivenTwoPosts_WhenReadAll_ThenBothPostsShouldAppear() {
        Repository repo2 = new Repository(
                "./test_read_post_repo2.txt",
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );

        Post post1 = new Post("Sxs", "Sxss");
        Post post2 = new Post("Ass", "Ssa");
        repo2.save(post1);
        repo2.save(post2);

        Assert.assertThat(repo2.readAll(), Matchers.contains(post1, post2));
    }
}
