package blog.domain;

import java.util.List;

public class ReadPostUseCase {

    //TODO: inheritance
    private Repository repo;

    public ReadPostUseCase(Repository repo) {
        this.repo = repo;
    }

    public List<Post> readAll() {
        return repo.readAll();
    }

    public Post read(String id) {
        return repo.read(id);
    }
}
