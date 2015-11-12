import hw3package.core.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Eva Sokolyanskaya on 11/11/2015.
 * HomeWork #3 Tests
 */
public class HwThird extends BaseTest {

    @Test(priority = 10, enabled = true)
    public void login() {
        loginPage.open();
        loginPage.setUerName();
        loginPage.setPassword();
        loginPage.clickLoginButton();
        Assert.assertTrue(userMenu.isLoggedIn());
    }

    @Test(priority = 20, enabled = true)
    public void goToAddNewPost() {
        userMenu.mouseMoveTo(userMenu.posts);
        userMenu.initAddNewPostLink().click();
        Assert.assertTrue(addNewPostPage.isElementPresented(addNewPostPage.addNewPostPageActive));
    }

    @Test(priority = 30, enabled = true)
    public void writeNewPost() {
        addNewPostPage.setMessageTitle(title);
        addNewPostPage.setMessageBody(messageText);
        addNewPostPage.clickOnPublishButton();
        Assert.assertTrue(editPostPage.isElementPresented(editPostPage.editNewPostPageActive));
    }

    @Test(priority = 40, enabled = true)
    public void checkPostCreated() {
        editPostPage.viewPost.click();
        Assert.assertEquals(viewPostPage.postTitle.getText(), title);
        Assert.assertEquals(viewPostPage.postBody.getText(), messageText);
    }

}


