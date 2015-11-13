package end2end;

import blog.domain.Post;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static java.lang.String.format;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class ReadPostsIT {
    @Value("${local.server.port}")
    private int port;

    @Autowired
    private InMemoryRepository repository;

    private Post[] posts = {new Post("JavaScript", "mola"), new Post("Java", "sucks")};

    @Test
    public void getPosts() {
        repository.save(posts);

        Response response = given().port(port).when().get("/posts");

        postsReceived(response, posts);
    }

    private void postsReceived(Response response, Post... posts) {
        response.then().body("$", Matchers.hasSize(posts.length));
        for (int i = 0; i < posts.length; i++) {
            postReceived(response, i, posts[i]);
        }
    }

    private void postReceived(Response response, int i, Post expected) {
        response.then().assertThat().body(format("[%d].title", i), equalTo(expected.getTitle()))
                .assertThat().body(format("[%d].text", i), equalTo(expected.getText()));
    }
}
