package infrastructure;

import domain.Post;
import domain.Repository;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.*;

public class FileRepository implements Repository {

    private OpenOption[] openOptions;
    private String path;

    public FileRepository(String path, OpenOption... options) {
        this.path = path;
        openOptions = options;
    }

    @Override
    public void save(Post... posts) throws IOException {
        String adaptedPost = "";
        for(Post post: posts) {
            adaptedPost += post.getTitle() + '\0' + post.getText() + '\n';
        }

        Files.write(Paths.get(path), adaptedPost.getBytes(), openOptions);
    }

    @Override
    public List<Post> readAll() throws IOException {
        List<Post> texts = new ArrayList<>();

        for (String line : Files.readAllLines(Paths.get(path), Charset.defaultCharset())) {
            String[] parts = line.split("\0");
            texts.add(new Post(parts[0], parts[1]));
        }

        return texts;
    }

    @Override
    public Post read(String title) throws IOException {
        List<Post> posts = this.readAll();

        for(Post post: posts) {
            if(post.getTitle().equals(title)) {
                return post;
            }
        }

        return null;
    }
}
