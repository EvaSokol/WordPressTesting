import hw2package.AddNewPostPage;
import hw2package.Common;
import hw2package.EditPostsPage;
import hw2package.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Eva Sokolyanskaya on 11/11/2015.
 * HomeWork #3 Tests
 */
public class HwThird {


    String userName;
    String password;
    String title;
    String messageText;

    @BeforeClass
    public void setUp() {
        userName = "admin";
        password = "admin";
        title = "qwertyTitle" + (int)(Math.random()*1000);
        messageText = "qwertyText" + (int)(Math.random()*1000);
    }

    @Test(priority = 10, enabled = true)
    public void login() {
        Common.login(userName, password);
        Assert.assertTrue(ProfilePage.isLoggedIn(userName));
    }

    @Test (priority = 20, enabled = true)
    public void goToAddNewPost() {
        Common.goToAddNewPost();
        Assert.assertTrue(AddNewPostPage.isAddNewPostPagePresented());
    }

    @Test (priority = 30, enabled = true)
    public void writeNewPost() {
        Common.writeNewPost(title, messageText);
        Assert.assertTrue(EditPostsPage.isPostPublished());
    }

    @Test (priority = 40, enabled = true)
    public void checkPostCreated() {
        Assert.assertTrue(Common.isPostPresented(title, messageText));
    }

    @AfterClass
    public void tearDown() {
        Common.close();
    }
}
