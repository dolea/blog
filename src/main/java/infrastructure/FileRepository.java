package infrastructure;

import domain.Post;
import domain.Repository;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

//TODO: exceptions
public class FileRepository implements Repository {

    private static final String DEFAULT_PATH = "./repo.txt";

    private OpenOption[] openOptions;
    private String path;

    public FileRepository(){
        this(DEFAULT_PATH, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    public FileRepository(String path, OpenOption... options) {
        this.path = path;
        openOptions = options;
    }

    @Override
    public void save(Post... posts) {
        String adaptedPost = "";
        for(Post post: posts) {
            adaptedPost += post.getTitle() + '\0' + post.getText() + '\n';
        }

        try {
            Files.write(Paths.get(path), adaptedPost.getBytes(), openOptions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
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

    @Override
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
