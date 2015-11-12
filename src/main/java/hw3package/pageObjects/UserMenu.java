package hw3package.pageObjects;

import hw3package.core.ApplicationSettings;
import hw3package.core.WebDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Eva Sokolyanskaya on 11/11/2015.
 * Page object for common user menu.
 */
public class UserMenu extends WebDriverActions{

    @FindBy(xpath = ".//li[@id='wp-admin-bar-my-account']/a")
    public WebElement loggedIn;

    @FindBy(xpath = ".//li[@id='menu-posts']/a/div[@class='wp-menu-name']")
    public WebElement posts;

//    @FindBy(xpath = ".//*[@id='menu-posts']/ul/li/a[@href='post-new.php']")
    public WebElement addNewPost;

//    public UserMenu() {
//        super();
//    }

    public boolean isLoggedIn() {
        String howdy = "Howdy, " + ApplicationSettings.userName;
        if (isElementPresented(loggedIn) &&
                isElementContainsText(loggedIn, howdy))
            return true;
        else return false;
    }

    public WebElement initAddNewPostLink() {
//        addNewPost = driver.findElement(By.xpath(".//*[@id='menu-posts']/ul/li/a[@href='post-new.php']"));
        addNewPost = (new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath(
                ".//*[@id='menu-posts']/ul/li/a[@href='post-new.php']")));
        return addNewPost;
    }
}
