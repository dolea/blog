package infrastructure;

import domain.Post;
import domain.PublishPostUseCase;
import domain.ReadPostUseCase;

import java.util.List;

public class RestManager {

    private ReadPostUseCase readPostUseCase;
    private PublishPostUseCase publishPostUseCase;

    public RestManager(ReadPostUseCase readPostUseCase, PublishPostUseCase publishPostUseCase) {
        this.readPostUseCase = readPostUseCase;
        this.publishPostUseCase = publishPostUseCase;
    }

    public List<Post> getPosts() {
        return readPostUseCase.readAll();
    }

    public Post getPost(String id) {
        return readPostUseCase.read(id);
    }

    public void postPost(String title, String text) {
        publishPostUseCase.publish(new Post(title, text));
    }
}
