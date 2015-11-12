package hw3package.core;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Eva Sokolyanskaya on 11/11/2015.
 */
public class WebDriverActions {

    protected static WebDriver driver;

//    protected WebDriverActions() {
//        if (driver == null) {
//            driver = new FirefoxDriver();
//            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        }
//    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
        return driver;
    }

    public void mouseMoveTo(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element);
        action.build().perform();
    }

    public static boolean isElementContainsText(WebElement element, String text) {
        if (element.getText().contains(text))
            return true;
        else return false;
    }

    public boolean isElementPresented(WebElement element) {
        if (element.isDisplayed())
            return true;
        else return false;
    }

    public void waitForElementEnabled(final By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return !driver.findElement(by).getAttribute("class").contains("disabled");
            }
        });
    }
}
