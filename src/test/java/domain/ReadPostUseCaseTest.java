package domain;

import infrastructure.Repository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.StandardOpenOption;

public class ReadPostUseCaseTest {
    private static final String REPO_PATH = "./test_repo.txt";

    private Repository repo;

    @Before
    public void initialize() {
        repo = new Repository(
                REPO_PATH,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING
        );
    }

    @Test
    public void read_GivenARepoWithAPost_WhenReadByPostId_ThenPostShouldReturn() {
        Post post = new Post("Lorem", "Ipsum");
        String id = repo.save(post.getTitle(), post.getText());
        ReadPostUseCase readPostUseCase = new ReadPostUseCase(repo);

        Assert.assertThat(readPostUseCase.read(id), Matchers.equalTo(post));
    }

    @Test
    public void read_GivenAnEmptyRepo_WhenReadById_ThenNullShouldReturn() {
        ReadPostUseCase readPostUseCase = new ReadPostUseCase(repo);

        Assert.assertNull(readPostUseCase.read("invalid"));
    }

    @Test
    public void read_GivenTwoPosts_WhenReadBySecondId_ThenSecondPostShouldReturn() {

        repo.save("first title", "first article");
        Post post2 = new Post("second title", "second text");
        String id2 = repo.save(post2.getTitle(), post2.getText());

        ReadPostUseCase readPostUseCase = new ReadPostUseCase(repo);
        Assert.assertThat(readPostUseCase.read(id2), Matchers.equalTo(post2));
    }

    @Test
    public void readAll_GivenTwoPostStored_WhenReadAll_ThenTwoPostsShouldReturn() {
        Post post1 = new Post("second title", "second text");
        repo.save(post1.getTitle(), post1.getText());

        Repository repoAppendable = new Repository(REPO_PATH, StandardOpenOption.APPEND);
        Post post2 = new Post("second title", "second text");
        repoAppendable.save(post2.getTitle(), post2.getText());

        ReadPostUseCase readPostUseCase = new ReadPostUseCase(repoAppendable);
        //TODO: Order dependant
        Assert.assertThat(readPostUseCase.readAll(), Matchers.<Post>contains(post2, post1));
    }
}
