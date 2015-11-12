package domain;

import infrastructure.Repository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.StandardOpenOption;

public class PublishPostUseCaseTest {
    private static final String REPO_PATH = "./test_repo.txt";
    private Post post = new Post("first title", "first text");

    @Test
    public void publish_GivenAPost_WhenPublish_ThenRepositoryShouldContainPost() {
        Repository repo = new Repository(REPO_PATH, StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        PublishPostUseCase publishPostUc = new PublishPostUseCase(repo);
        String id = publishPostUc.publish(post);

        Assert.assertThat(repo.read(id), Matchers.equalTo(post));
    }

    @Test
    public void publish_GivenAPost_WhenAppended_TheRepositoryShouldContainBothPosts() {
        Post post2 = new Post("second title", "second text");

        Repository repo = new Repository(REPO_PATH, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        PublishPostUseCase publishPostUc = new PublishPostUseCase(repo);

        publishPostUc.publish(post2);

        //TODO: order dependant
        Assert.assertThat(repo.readAll(), Matchers.<Post>contains(post, post2));
    }
}
