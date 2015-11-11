package domain;

import infrastructure.Repository;

import java.util.List;

public class ReadPostUseCase {

    private Repository repo;

    public ReadPostUseCase(Repository repo) {
        this.repo = repo;
    }

    public List<String> readAll() {
        return repo.readAll();
    }

    public String read(String id) {
        return repo.read(id);
    }
}
