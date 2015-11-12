package hw3package.pageObjects;

import hw3package.core.WebDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.awt.windows.ThemeReader;

/**
 * Created by Eva Sokolyanskaya on 12/11/2015.
 */
public class AllPostsPage extends WebDriverActions {

    @FindBy(xpath = ".//*[@id='wpbody-content']//h1[contains(text(), 'Posts')]")
    public WebElement allPostsPage;

    @FindBy(xpath = ".//*[@id='bulk-action-selector-top']")
    private WebElement bulkActions;

    @FindBy(xpath = ".//*[@id='posts-filter']//span[@class='displaying-num']")
    private WebElement number;

    @FindBy(xpath = ".//*[@id='doaction']")
    private WebElement applyButton;

//    .//*[@id='posts-filter']//span[@class='displaying-num']

    public boolean isNumberChanged(){
        String data = driver.findElement(By.xpath(".//*[@id='posts-filter']//span[@class='displaying-num']")).getText();
        Integer number = Integer.parseInt(data.split(" ")[0]);
        number--;
        String newData = number.toString();
        waitForElementText(By.xpath(".//*[@id='posts-filter']//span[@class='displaying-num']"), newData);
        return true;
    }

    public void moveToTrash() throws InterruptedException {
        mouseClick(bulkActions);
        WebElement trashOption = driver.findElement(By.xpath(".//*[@id='bulk-action-selector-top']/option[@value='trash']"));
        mouseMoveTo(trashOption);
        mouseClick(trashOption);
        waitForElementEnabled(By.xpath(".//*[@id='doaction']"));
        applyButton.click();
        Wait<WebDriver> wait = new WebDriverWait(driver, 30);

    }

//    public WebElement currentPostCheckBox = driver.findElement(By.xpath(".//th/*[contains(text(), 'qwerty')]/../input[@type='checkbox']"));

    public WebElement currentPostCheckBox (String title) {
        WebElement currentPostCheckBox = driver.findElement(By.xpath(".//th/*[contains(text(), '" + title + "')]/../input[@type='checkbox']"));


        return currentPostCheckBox;
    }
}
