package hw3package.pageObjects;

import hw3package.core.ApplicationSettings;
import hw3package.core.WebDriverActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Eva Sokolyanskaya on 11/11/2015.
 */
public class UserMenu extends WebDriverActions{

    @FindBy(xpath = ".//li[@id='wp-admin-bar-my-account']/a")
    public WebElement loggedIn;

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
}
