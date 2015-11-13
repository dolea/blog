package domain;

import java.io.IOException;
import java.util.List;

public class ReadPostUseCase {

    //TODO: inheritance
    private Repository repo;

    public ReadPostUseCase(Repository repo) {
        this.repo = repo;
    }

    public List<Post> readAll() throws IOException {
        return repo.readAll();
    }

    public Post read(String id) throws IOException {
        return repo.read(id);
    }
}
