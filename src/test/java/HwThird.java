import hw3package.core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Eva Sokolyanskaya on 11/11/2015.
 * HomeWork #3 Tests
 */
public class HwThird extends BaseTest {

    @Test(priority = 10, enabled = true)
    public void login() {
        open();
        loginPage.setUerName();
        loginPage.setPassword();
        loginPage.clickLoginButton();
        Assert.assertTrue(userMenu.isLoggedIn());
    }

//    @Test(priority = 20, enabled = true)
//    public void goToAddNewPost() {
//        Common.goToAddNewPost();
//        Assert.assertTrue(AddNewPostPage.isAddNewPostPagePresented());
//    }
//
//    @Test(priority = 30, enabled = true)
//    public void writeNewPost() {
//        Common.writeNewPost(title, messageText);
//        Assert.assertTrue(EditPostsPage.isPostPublished());
//    }
//
//    @Test(priority = 40, enabled = true)
//    public void checkPostCreated() {
//        Assert.assertTrue(Common.isPostPresented(title, messageText));
//    }

}


