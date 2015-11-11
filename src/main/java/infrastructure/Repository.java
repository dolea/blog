package infrastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {

    private Map<String, String> posts = new HashMap<>();
    private Integer publishCounter = 0;

    public String save(String text) {
        String id = this.generateNextId();
        posts.put(id, text);

        return id;
    }

    public List<String> readAll() {
        List<String> texts = new ArrayList<>();
        for (String key: posts.keySet()) {
            texts.add(this.read(key));
        }

        return texts;
    }

    public String read(String id) {
        return posts.get(id);
    }

    private String generateNextId() {
        publishCounter++;
        return publishCounter.toString();
    }
}
