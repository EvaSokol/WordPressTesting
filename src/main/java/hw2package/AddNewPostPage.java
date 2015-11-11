package hw2package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Eva Sokolyanskaya on 08/11/2015.
 * Add New Post page objects
 */
public class AddNewPostPage {

    private static WebDriver driver = Common.getDriver();
    private static WebElement addPostPage =
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                ".//div[@id='wpbody-content']/div[@class='wrap']/h1")));

    private static WebElement titleField = driver.findElement(By.xpath(".//label[@id='title-prompt-text']"));
    private static WebElement messageBody;
    private static WebElement publishButton;

    public static boolean isAddNewPostPagePresented() {
        String addNewTextString = "Add New Post";
        if (
                addPostPage.isDisplayed() &&
                        addPostPage.getText().equalsIgnoreCase(addNewTextString))
            return true;
        else return false;
    }

    public static WebElement getTitleField() {
        return titleField;
    }

    private static void initMessageBody(String messageText) {

//        driver.switchTo().frame("content_ifr");
//        messageBody = driver.findElement(By.xpath("//body"));
//        messageBody.click();
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].innerHTML='" + messageText + "'", messageBody);
//        driver.switchTo().defaultContent();

        driver.switchTo().frame("content_ifr");
        driver.switchTo().activeElement().sendKeys(messageText);
        driver.switchTo().defaultContent();
    }

    public static void putMessageBody(String messageText) {
        if (messageBody == null)
            initMessageBody(messageText);
    }

    public static WebElement getPublishButton() {
        if (publishButton == null)
            initPublishButton();
        return publishButton;
    }

    private static void initPublishButton() {
//        publishButton = driver.findElement(By.xpath(".//input[@id='publish']"));
//        publishButton = (new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath(
//                ".//*[@id='publish']")));
        publishButton = (new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath(
                ".//*[@class='button button-primary button-large']")));

    }
}
