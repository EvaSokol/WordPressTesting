import hw3package.core.BaseTest;
import hw3package.core.Temporator;
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

    @Test(priority = 50, enabled = true)
    public void goToAllPosts() {
        userMenu.editPost.click();
        userMenu.allPosts.click();
        Assert.assertTrue(allPostsPage.allPostsPage.isEnabled());
    }

    @Test(priority = 60, enabled = true)
    public void deleteCurrentPost() throws InterruptedException {
//        allPostsPage.currentPostCheckBox(title).isSelected();
//        allPostsPage.mouseMoveTo(allPostsPage.currentPostCheckBox(title));
        allPostsPage.mouseClick(allPostsPage.currentPostCheckBox(title));
        allPostsPage.moveToTrash();
//        allPostsPage.isNumberChanged();
//        Thread.sleep(10000);
        Assert.assertFalse(allPostsPage.currentPostCheckBox(title).isDisplayed());

//        Temporator.main();
    }
}


