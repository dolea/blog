package infrastructure;

import domain.Post;
import domain.PublishPostUseCase;
import domain.ReadPostUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class RestManager {

    private ReadPostUseCase readPostUseCase;
    private PublishPostUseCase publishPostUseCase;

    public RestManager(ReadPostUseCase readPostUseCase, PublishPostUseCase publishPostUseCase) {
        this.readPostUseCase = readPostUseCase;
        this.publishPostUseCase = publishPostUseCase;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Post> getPosts() {
        return readPostUseCase.readAll();
    }

    @RequestMapping(name = "/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable String id) {
        return readPostUseCase.read(id);
    }

    @RequestMapping(name = "/{id}", method = RequestMethod.POST, consumes="application/json")
    public void postPost(@PathVariable String id, @RequestBody String text) {
        publishPostUseCase.publish(new Post(id, text));
    }
}
