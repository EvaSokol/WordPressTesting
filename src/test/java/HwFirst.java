
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by MASK on 05/11/2015.
 */
public class HwFirst {

        protected static WebDriver driver;

        @Test
        public void Lesson1(){
            String baseUrl = "http://localhost/wordpress/wp-login.php";
            driver = new FirefoxDriver();
            driver.navigate().to(baseUrl);
            driver.findElement(By.id("user_login")).clear();
            driver.findElement(By.id("user_login")).sendKeys("Eva");
            driver.findElement(By.id("user_pass")).clear();
            driver.findElement(By.id("user_pass")).sendKeys("eva123");
            driver.findElement(By.id("wp-submit")).click();
            driver.close();
            driver.quit();
            }

}
