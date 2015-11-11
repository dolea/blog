package domain;

import infrastructure.Repository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ReadPostUseCaseTest {

    @Test
    public void read_GivenValidId() {
        Repository repo = new Repository();
        Post post = new Post("Lorem", "Ipsum");
        String id = repo.save(post.getTitle(), post.getText());
        ReadPostUseCase readPostUseCase = new ReadPostUseCase(repo);

        Assert.assertThat(readPostUseCase.read(id), Matchers.equalTo(post));
    }

    @Test
    public void read_GivenInValidId() {
        Repository repo = new Repository();
        ReadPostUseCase readPostUseCase = new ReadPostUseCase(repo);

        Assert.assertNull(readPostUseCase.read("invalid"));
    }

    @Test
    public void read_GivenTwoPosts_RetrieveSecond() {
        Repository repo = new Repository();
        repo.save("first title", "first article");

        Post post2 = new Post("second title", "second text");
        String id2 = repo.save(post2.getTitle(), post2.getText());

        ReadPostUseCase readPostUseCase = new ReadPostUseCase(repo);
        Assert.assertThat(readPostUseCase.read(id2), Matchers.equalTo(post2));
    }

    @Test
    public void readAll() {
        Post post1 = new Post("first title", "first text");
        Post post2 = new Post("second title", "second text");
        Repository repo = new Repository();
        repo.save(post1.getTitle(), post1.getText());
        repo.save(post2.getTitle(), post2.getText());

        ReadPostUseCase readPostUseCase = new ReadPostUseCase(repo);
        //TODO: Order dependant
        Assert.assertThat(readPostUseCase.readAll(), Matchers.<Post>contains(post2, post1));
    }
}
