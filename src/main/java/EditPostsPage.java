import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Eva Sokolyanskaya on 08/11/2015.
 */
public class EditPostsPage {

    private static WebDriver driver = Common.getDriver();
    private static WebElement editPostPage =
            (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    ".//div[@id='wpbody-content']/div[@class='wrap']/h1")));
    private static WebElement postPublished = driver.findElement(By.xpath(".//div[@id='message']/p"));

    private static WebElement viewPost = driver.findElement(By.xpath(".//div[@id='message']/p/a"));

    public static boolean isEditPostPagePresented() {
        String editPostString = "Edit Post";
        if (editPostPage.isDisplayed() && editPostPage.getText().contains(editPostString))
            return true;
        else return false;
    }

    public static boolean isPostPublished() {
        String postPublishedString = "Post published.";
        if (postPublished.getText().contains(postPublishedString))
            return true;
        else return false;
    }

    public static WebElement getViewPost() {
        return viewPost;
    }
}
