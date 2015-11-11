package hw2package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Eva Sokolyanskaya on 08/11/2015.
 * Login page objects
 */
public class LoginPage {

    private static WebDriver driver = Common.getDriver();

    static WebElement loginField = driver.findElement(By.xpath(".//input[@id='user_login']"));
    static WebElement passwordField = driver.findElement(By.xpath(".//input[@id='user_pass']"));
    static WebElement submitButton = driver.findElement(By.xpath(".//input[@id='wp-submit']"));

}
