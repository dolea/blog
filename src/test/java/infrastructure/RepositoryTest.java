package infrastructure;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class RepositoryTest {

    @Test
    public void save() {
        Repository repo = new Repository();
        String text = "Lorem";
        String id = repo.save(text);
        Assert.assertNotNull(id);
    }

    @Test
    public void readInvalidId() {
        Repository repo = new Repository();
        Assert.assertNull(repo.read("invalid"));
    }

    @Test
    public void readValidId() {
        Repository repo = new Repository();
        String text = "Lerom";
        String id = repo.save(text);
        Assert.assertThat(repo.read(id), Matchers.equalTo(text));
    }
}
