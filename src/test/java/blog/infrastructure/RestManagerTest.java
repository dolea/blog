package blog.infrastructure;

import blog.domain.Post;
import blog.domain.PublishPostUseCase;
import blog.domain.ReadPostUseCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class RestManagerTest {

    @Mock
    private ReadPostUseCase readPostUseCase;
    @Mock
    private PublishPostUseCase publishPostUseCase;
    @InjectMocks
    private RestManager restManager;

    @Test
    public void GivenAPost_WhenGetPostIsCalledWithId_ThenReadShouldBeCalledWithId(){
        String title = "title";
        when(readPostUseCase.read(title)).thenReturn(any(Post.class));

        restManager.getPost(title);

        verify(readPostUseCase).read(eq(title));
    }

    @Test
    public void GivenAListOfPosts_WhenGetPosts_ThenReadAllShouldBeCalled() {
        when(readPostUseCase.readAll()).thenReturn(new ArrayList<>());

        restManager.getPosts();

        verify(readPostUseCase).readAll();
    }

    @Test
    public void GivenATitleAndAText_WhenPostPostIsCalled_ThenPublishShouldBeCalled() {
        String title = "title4";
        String text = "text4";

        restManager.postPost(title, text);

        verify(publishPostUseCase).publish(eq(new Post(title, text)));
    }
}
