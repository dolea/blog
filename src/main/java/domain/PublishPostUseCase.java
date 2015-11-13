package domain;

import java.io.IOException;

public class PublishPostUseCase {
    private Repository repo;

    public PublishPostUseCase(Repository repo) {
        this.repo = repo;
    }

    public void publish(Post post) throws IOException {
        repo.save(post);
    }
}
