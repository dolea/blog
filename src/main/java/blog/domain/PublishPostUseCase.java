package blog.domain;

public class PublishPostUseCase {
    private Repository repo;

    public PublishPostUseCase(Repository repo) {
        this.repo = repo;
    }

    public void publish(Post post) {
        repo.save(post);
    }
}