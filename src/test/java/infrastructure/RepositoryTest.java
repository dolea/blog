package infrastructure;

import domain.Post;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class RepositoryTest {

    @Test
    public void save() {
        Repository repo = new Repository();
        String text = "Lorem";
        String title = "Ipsum";
        String id = repo.save(title, text);
        Assert.assertThat(id, Matchers.equalTo(title));
    }

    @Test
    public void readInvalidTitle() {
        Repository repo = new Repository();
        Assert.assertNull(repo.read("invalid"));
    }

    @Test
    public void readValidTitle() {
        Repository repo = new Repository();
        String text = "Dolor";
        String title = "Sit";
        repo.save(title, text);
        Assert.assertThat(repo.read(title).getText(), Matchers.equalTo(text));
    }
}
