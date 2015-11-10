package domain;

import org.junit.Assert;
import org.junit.Test;

public class PostTest {

    @Test
    public void getAuthor_WhenAuthorIsDaniel_Olea_ShouldReturnDaniel_Olea() {
        Post testPost = new Post("Daniel Olea", "", null);
        Assert.assertEquals("Daniel Olea", testPost.getAuthor());
    }

    @Test
    public void getTitle_WhenTitleIsLorem_ShouldReturnLorem() {
        Post testPost = new Post("Daniel Olea", "Lorem", null);
        Assert.assertEquals("Lorem", testPost.getTitle());
    }
}
