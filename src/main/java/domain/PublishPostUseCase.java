package domain;

import infrastructure.Repository;

public class PublishPostUseCase {
    private Repository repo;

    public PublishPostUseCase(Repository repo) {
        this.repo = repo;
    }

    public String publish(Post post) {
        return repo.save(post);
    }
}
