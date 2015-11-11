package hw3package.core;

import hw3package.pageObjects.LoginPage;
import hw3package.pageObjects.UserMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created by Eva Sokolyanskaya on 11/11/2015.
 * Class to inheritance for all tests.
 */
public class BaseTest {

    protected static WebDriver driver = WebDriverActions.getDriver();
    protected LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    protected UserMenu userMenu = PageFactory.initElements(driver, UserMenu.class);

    String title;
    String messageText;
    public String loginPageUrl = ApplicationSettings.baseUrl + "/wp-login.php";

    public void open() {
        driver.navigate().to(loginPageUrl);
    }

    @BeforeTest
    public void setUp() {
        title = "qwertyTitle" + (int)(Math.random()*1000);
        messageText = "qwertyText" + (int)(Math.random()*1000);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
