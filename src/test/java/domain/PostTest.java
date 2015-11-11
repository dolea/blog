package domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class PostTest {

    private Post testPost;
    private Date dateTest;

    @Before
    public void initialize() {
        dateTest = new Date();
        testPost = new Post("Daniel Olea", "Lorem", dateTest, "Lorem ipsum");
    }

    @Test
    public void getAuthor_WhenAuthorIsDaniel_Olea_ShouldReturnDaniel_Olea() {
        Assert.assertEquals("Daniel Olea", testPost.getAuthor());
    }

    @Test
    public void getTitle_WhenTitleIsLorem_ShouldReturnLorem() {
        Assert.assertEquals("Lorem", testPost.getTitle());
    }

    @Test
    public void getDate_WhenDateObjectPassed_ShouldReturnDateObject() {
        Assert.assertEquals(dateTest, testPost.getDate());
    }

    @Test
    public void getBody_WhenStringPassed_ShouldReturnString() {
        Assert.assertEquals("Lorem ipsum", testPost.getBody());
    }
}
