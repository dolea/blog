package blog.infrastructure;

import blog.domain.Post;
import org.hamcrest.Matchers;
import org.junit.*;

import java.io.File;
import java.nio.file.StandardOpenOption;

public class FileRepositoryTest {
    private static final String TEST_REPO_PATH = "./test_repo.txt";

    private FileRepository repo;

    @Before
    public void initialize() {
        repo = new FileRepository(
                TEST_REPO_PATH,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE
        );
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
        Post post1 = new Post("Sxs", "Sxss");
        Post post2 = new Post("Ass", "Ssa");
        repo.save(post1, post2);

        Assert.assertThat(repo.readAll(), Matchers.contains(post1, post2));
    }

    @AfterClass
    public static void clean() {
        File file = new File(TEST_REPO_PATH);
        file.delete();
    }
}
