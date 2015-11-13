package hw3package.core;

import hw3package.pageObjects.AllPostsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Eva Sokolyanskaya on 13/11/2015.
 */
public class Temporator extends WebDriverActions{

    public static WebElement button = driver.findElement(By.xpath(".//*[@value='Apply']"));

    public static void main() {

        for (int i=0; i<1; i++) {
            System.out.println("value = " + button.getAttribute("value"));
            System.out.println("id = " + button.getAttribute("id"));
            System.out.println("class = " + button.getAttribute("class"));
            System.out.println("type = " + button.getAttribute("type"));
        }
    }

}
