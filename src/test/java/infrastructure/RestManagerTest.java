package infrastructure;

import com.jayway.restassured.RestAssured;
import domain.Post;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.StandardOpenOption;

public class RestManagerTest {

    private Post post1, post2, post3;
    private Repository repo;

    @Before
    public void initialize(){
        post1 = new Post("title1", "text1");
        post2 = new Post("title2", "text2");
        post3 = new Post("title3", "text3");

        repo = new Repository(".test_rest_manager_repo.txt", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        repo.save(post1, post2, post3);
    }

    @Test
    public void GivenThreeStoredPosts_WhenGetPostsIsCalled_ShouldReturnAllThreePosts(){
        Assert.assertThat(RestManager.getPosts(), Matchers.contains(post1, post2, post3));
    }
}
