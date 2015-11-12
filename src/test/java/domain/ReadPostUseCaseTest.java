package domain;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ReadPostUseCaseTest {

    @Mock
    private Repository repo;
    @InjectMocks
    private ReadPostUseCase readPostUseCase;

    @Test
    public void givenAPost_whenReadByPostId_ThenPostShouldReturn() {
        String title = "Lorem";
        Post post = new Post(title, "Ipsum");

        Mockito.when(repo.read(title)).thenReturn(post);

        Assert.assertThat(readPostUseCase.read(title), Matchers.equalTo(post));
    }

    @Test
    public void givenTwoPosts_WhenReadAll_ThenTwoPostsShouldReturn() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("title", "text"));
        posts.add(new Post("title", "text"));

        Mockito.when(repo.readAll()).thenReturn(posts);

        Assert.assertThat(readPostUseCase.readAll(), Matchers.equalTo(posts));
    }
}
