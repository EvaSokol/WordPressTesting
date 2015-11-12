package hw3package.pageObjects;

import hw3package.core.ApplicationSettings;
import hw3package.core.WebDriverActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Eva Sokolyanskaya on 11/11/2015.
 */
public class LoginPage extends WebDriverActions {

//    public LoginPage() {
//        super();
//    }

    public static String loginPageUrl = ApplicationSettings.baseUrl + "/wp-login.php";

    public static void open() {
        driver.navigate().to(loginPageUrl);
    }

    @FindBy(xpath = ".//input[@id='user_login']")
    public WebElement userNameField;

    @FindBy(xpath = ".//input[@id='user_pass']")
    public WebElement passwordField;

    @FindBy(xpath = ".//input[@id='wp-submit']")
    public WebElement loginButton;



    public void setUerName() {
        userNameField.clear();
        userNameField.sendKeys(ApplicationSettings.userName);
    }

    public void setPassword() {
        passwordField.clear();
        passwordField.sendKeys(ApplicationSettings.password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
