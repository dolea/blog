package blog.infrastructure;

import blog.domain.Post;
import blog.domain.PublishPostUseCase;
import blog.domain.ReadPostUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class RestManager {

    private ReadPostUseCase readPostUseCase;
    private PublishPostUseCase publishPostUseCase;

    @Autowired
    public RestManager(ReadPostUseCase readPostUseCase, PublishPostUseCase publishPostUseCase) {
        this.readPostUseCase = readPostUseCase;
        this.publishPostUseCase = publishPostUseCase;
    }

    @RequestMapping
    public List<Post> getPosts() {
        return readPostUseCase.readAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable String id) {
        return readPostUseCase.read(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes="application/json")
    public void postPost(@PathVariable String id, @RequestBody String text) {
        publishPostUseCase.publish(new Post(id, text));
    }
}
