package domain;

import infrastructure.Repository;

public class PublishPostUseCase {
    private Repository repo;

    public PublishPostUseCase(Repository repo) {
        this.repo = repo;
    }

    public String publish(String title, String text) {
        return repo.save(title, text);
    }
}
