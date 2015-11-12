package infrastructure;

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
        String text = "Lorem";
        String title = "Ipsum";
        String id = repo.save(title, text);
        Assert.assertThat(id, Matchers.equalTo(title));
    }

    @Test
    public void read_GivenATitleNotStored_WhenReadById_ThenShouldReturnNull() {
        Assert.assertNull(repo.read("invalid"));
    }

    @Test
    public void read_GivenATitleStored_WhenReadByPostId_ThenShouldReturnPost() {
        String text = "Dolor";
        String title = "Sit";
        repo.save(title, text);
        Assert.assertThat(repo.read(title).getText(), Matchers.equalTo(text));
    }

    @Test
    public void read_GivenTwoPosts_WhenReadAll_ThenBothPostsShouldAppear() {
        Repository repo2 = new Repository(
                "./test_repo.txt",
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );

        String text = "Xaz";
        String title = "zaX";
        repo2.save(title, text);
        repo2.save("xxx", "zzz");
        Assert.assertThat(repo2.read(title).getText(), Matchers.equalTo(text));
    }
}
