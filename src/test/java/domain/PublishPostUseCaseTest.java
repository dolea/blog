package domain;

import infrastructure.Repository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class PublishPostUseCaseTest {
    @Test
    public void publishPost() {
        String text = "an article";
        Repository repo = new Repository();
        PublishPostUseCase publishPostUc = new PublishPostUseCase(repo);
        String id = publishPostUc.publish(text);

        Assert.assertThat(repo.read(id), Matchers.equalTo(text));
    }

    @Test
    public void publishTwoPosts() {
        String text1 = "first article";
        String text2 = "second article";
        Repository repo = new Repository();
        PublishPostUseCase publishPostUc = new PublishPostUseCase(repo);
        publishPostUc.publish(text1);
        publishPostUc.publish(text2);

        Assert.assertThat(repo.readAll(), Matchers.contains(text1, text2));
    }
}
