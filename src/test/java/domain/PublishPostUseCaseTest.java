package domain;

import infrastructure.Repository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PublishPostUseCaseTest {
    @Test
    public void publishPost() {
        Post post = new Post("first title", "first text");

        Repository repo = new Repository();
        PublishPostUseCase publishPostUc = new PublishPostUseCase(repo);
        String id = publishPostUc.publish(post.getTitle(), post.getText());

        Assert.assertThat(repo.read(id), Matchers.equalTo(post));
    }

    @Test
    public void publishTwoPosts() {
        Post post1 = new Post("first title", "first text");
        Post post2 = new Post("second title", "second text");

        Repository repo = new Repository();
        PublishPostUseCase publishPostUc = new PublishPostUseCase(repo);

        publishPostUc.publish(post1.getTitle(), post1.getText());
        publishPostUc.publish(post2.getTitle(), post2.getText());

        //TODO: order dependant
        Assert.assertThat(repo.readAll(), Matchers.<Post>contains(post2, post1));
    }
}
