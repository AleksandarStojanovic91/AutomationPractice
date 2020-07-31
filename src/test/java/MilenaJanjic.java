import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MilenaJanjic {

    public class AutomationPractice {


        public static WebDriver driver;
        String URL = "http://automationpractice.com/index.php";

        @Before
        public void setUp() {
            System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(URL);
        }

        @Test
        public void registrationAutomationPractice() throws InterruptedException{
            driver.findElement(By.cssSelector(".login")).click();
            Thread.sleep(5000);;
            driver.findElement(By.cssSelector("#email_create")).sendKeys("asd123dsf@gmail.com");
            Thread.sleep(5000);
            driver.findElement(By.cssSelector(".btn.btn-default.button.button-medium.exclusive")).click();
            Thread.sleep(5000);
        }

        @After
        public void tearDown(){
            driver.close();
            driver.quit();
        }
    }
}
