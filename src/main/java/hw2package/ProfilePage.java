package hw2package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Eva Sokolyanskaya on 08/11/2015.
 * Profile page objects
 */
public class ProfilePage {

    private static WebDriver driver = Common.getDriver();
    private static WebElement profilePage = driver.findElement(By.xpath("//*[@id='wp-admin-bar-my-account']/a"));
    private static WebElement postsButton = driver.findElement(By.xpath(".//li[@id='menu-posts']/a/div[@class='wp-menu-name']"));

    private static WebElement newPostButton;

    public static boolean isLoggedIn(String userName) {
        String howdy = "Howdy, " + userName;

        if (profilePage.isDisplayed() && profilePage.getText().equalsIgnoreCase(howdy))
            return true;
        else return false;
    }

    public static void initNewPostButton() {
        newPostButton =
                (new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath(
                    ".//*[@id='menu-posts']/ul/li/a[@href='post-new.php']")));
    }

    public static WebElement getPostsButton() {
        return postsButton;
    }

    public static WebElement getNewPostButton() {
        return newPostButton;
    }
}
