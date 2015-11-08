
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Eva Sokolyanskaya on 05/11/2015.
 */
public class HwFirst {

        protected static WebDriver driver;

        @Test
        public void Lesson1() throws InterruptedException {
            String baseUrl = "http://localhost/wordpress/wp-login.php";
            driver = new FirefoxDriver();
            driver.navigate().to(baseUrl);
            driver.findElement(By.id("user_login")).clear();
            driver.findElement(By.id("user_login")).sendKeys("user1");
            driver.findElement(By.id("user_pass")).clear();
            driver.findElement(By.id("user_pass")).sendKeys("user1");
            driver.findElement(By.id("wp-submit")).click();

            Assert.assertTrue(driver.findElement(By.id("profile-page")).isDisplayed());

            driver.close();
            driver.quit();
            }

}
