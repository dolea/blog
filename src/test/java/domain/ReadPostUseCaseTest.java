package domain;

import infrastructure.Repository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ReadPostUseCaseTest {

    @Test
    public void read_GivenValidId() {
        Repository repo = new Repository();
        String text = "Lerolero";
        String id = repo.save(text);
        ReadPostUseCase readPostUseCase = new ReadPostUseCase(repo);

        Assert.assertThat(readPostUseCase.read(id), Matchers.equalTo(text));
    }

    @Test
    public void read_GivenInValidId() {
        Repository repo = new Repository();
        ReadPostUseCase readPostUseCase = new ReadPostUseCase(repo);

        Assert.assertNull(readPostUseCase.read("invalid"));
    }

    @Test
    public void read_GivenTwoPosts_RetrieveSecond() {
        String text1 = "first article";
        String text2 = "second article";
        Repository repo = new Repository();
        repo.save(text1);
        String id2 = repo.save(text2);

        ReadPostUseCase readPostUseCase = new ReadPostUseCase(repo);
        Assert.assertThat(readPostUseCase.read(id2), Matchers.equalTo(text2));
    }

    @Test
    public void readAll() {
        String text1 = "first article";
        String text2 = "second article";
        Repository repo = new Repository();
        repo.save(text1);
        repo.save(text2);

        ReadPostUseCase readPostUseCase = new ReadPostUseCase(repo);
        Assert.assertThat(readPostUseCase.readAll(), Matchers.contains(text1, text2));
    }
}
