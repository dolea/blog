package domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PublishPostUseCaseTest {

    @Mock
    private Repository repo;
    @InjectMocks
    private PublishPostUseCase publishPostUseCase;

    @Test
    public void givenAPost_WhenPublish_ThenSaveShouldBeCalled() throws IOException {
        Post post = new Post("first title", "first text");

        publishPostUseCase.publish(post);

        verify(repo).save(eq(post));
    }
}
