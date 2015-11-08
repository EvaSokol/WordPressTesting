import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Eva Sokolyanskaya on 08/11/2015.
 */
public class ViewPostPage {

    private static WebDriver driver = Common.getDriver();
    private static WebElement postTitle = driver.findElement(By.xpath(".//article/header/h1[@class='entry-title']"));
    private static WebElement postBody = driver.findElement(By.xpath(".//article/div[@class='entry-content']/p"));

    public static WebElement getPostTitle() {
        return postTitle;
    }

    public static WebElement getPostBody() {
        return postBody;
    }
}
