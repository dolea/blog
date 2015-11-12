package infrastructure;

import domain.Post;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Repository {

    private static final String DEFAULT_PATH = "./repo.txt";

    private OpenOption[] openOptions;
    private String path;

    public Repository(){
        this(DEFAULT_PATH, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    public Repository(String path, OpenOption... options) {
        this.path = path;
        openOptions = options;
    }

    public void save(Post... posts) {
        for(Post post: posts) {
            String adaptedPost = post.getTitle() + '\0' + post.getText() + '\n';
            try {
                Files.write(Paths.get(path), adaptedPost.getBytes(), openOptions);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Post> readAll() {
        List<Post> texts = new ArrayList<>();

        try {
            for (String line : Files.readAllLines(Paths.get(path), Charset.defaultCharset())) {
                String[] parts = line.split("\0");
                texts.add(new Post(parts[0], parts[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return texts;
    }

    public Post read(String title) {
        List<Post> posts = this.readAll();

        for(Post post: posts) {
            if(post.getTitle().equals(title)) {
                return post;
            }
        }
        return null;
    }
}
