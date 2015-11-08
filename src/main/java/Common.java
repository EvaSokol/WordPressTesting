import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Eva Sokolyanskaya on 08/11/2015.
 * Common methods class
 */
public class Common {

    private static WebDriver driver;
    protected static String loginPageUrl = "http://localhost/wordpress/wp-login.php";
    private static Actions action;

    public static WebDriver getDriver() {
        if (driver == null)
            driver = new FirefoxDriver();
        return driver;
    }

    public static void goToUrl(String url) {
        driver = getDriver();
        driver.navigate().to(url);
    }

    public static void login (String userName, String password) {
        goToUrl(loginPageUrl);
        LoginPage.loginField.clear();
        LoginPage.loginField.sendKeys(userName);
        LoginPage.passwordField.clear();
        LoginPage.passwordField.sendKeys(password);
        LoginPage.submitButton.click();
    }

    public static void goToAddNewPost() {
        action = new Actions(driver);
        action.moveToElement(ProfilePage.getPostsButton());
        action.build().perform();
        ProfilePage.initNewPostButton();
        ProfilePage.getNewPostButton().click();
    }

    public static void writeNewPost(String title, String messageText) {
        AddNewPostPage.getTitleField().sendKeys(title);
        AddNewPostPage.getTitleField().sendKeys(Keys.TAB + messageText);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        AddNewPostPage.getPublishButton().click();
    }

    public static boolean isPostPresented(String title, String messageText) {
        EditPostsPage.getViewPost().click();
        if (ViewPostPage.getPostTitle().getText().contains(title) &&
                ViewPostPage.getPostBody().getText().contains(messageText))
            return true;
        else return false;
    }

    public static void close() {
        driver.close();
    }
}
