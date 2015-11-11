package infrastructure;

import domain.Post;

import java.util.*;

public class Repository {

    private Map<String, String> posts = new HashMap<>();

    public String save(String title, String text) {
        posts.put(title, text);
        return title;
    }

    public List<Post> readAll() {
        List<Post> texts = new ArrayList<>();
        for (String key: posts.keySet()) {
            texts.add(this.read(key));
        }

        return texts;
    }

    public Post read(String title) {
        if(posts.containsKey(title)) {
            return new Post(title, posts.get(title));
        }
        return null;
    }
}
