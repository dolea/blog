package infrastructure;

import domain.Post;
import domain.PublishPostUseCase;
import domain.ReadPostUseCase;

import java.io.IOException;
import java.util.List;

public class RestManager {

    private ReadPostUseCase readPostUseCase;
    private PublishPostUseCase publishPostUseCase;

    public RestManager(ReadPostUseCase readPostUseCase, PublishPostUseCase publishPostUseCase) {
        this.readPostUseCase = readPostUseCase;
        this.publishPostUseCase = publishPostUseCase;
    }

    public List<Post> getPosts() {
        try {
            return readPostUseCase.readAll();
        } catch (IOException e) {
            //TODO:
            return null;
        }
    }

    public Post getPost(String id) {
        try {
            return readPostUseCase.read(id);
        } catch (IOException e) {
            //TODO:
            return null;
        }
    }

    public void postPost(String title, String text) {
        try {
            publishPostUseCase.publish(new Post(title, text));
        } catch (IOException e) {
            //TODO:
        }
    }
}
