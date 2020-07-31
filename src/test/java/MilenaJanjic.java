import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class MilenaJanjic {

    public static class AutomationPractice {


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
            driver.findElement(By.cssSelector("#SubmitCreate")).click();
            Thread.sleep(5000);
            driver.findElement(By.cssSelector("#id_gender1")).click();
            driver.findElement(By.cssSelector("#customer_firstname")).sendKeys("Milena");
            driver.findElement(By.cssSelector("#customer_lastname")).sendKeys("Janjic");
            driver.findElement(By.cssSelector("#email")).clear();
            driver.findElement(By.cssSelector("#email")).sendKeys("asd123dsf@gmail.com");
            driver.findElement(By.cssSelector("#passwd")).sendKeys("qqqqw");
            Thread.sleep(5000);

            Select daySelect = new Select(driver.findElement(By.cssSelector("days")));
            daySelect.selectByValue("7");

            Select monthSelect = new Select(driver.findElement(By.cssSelector("month")));
            monthSelect.selectByValue("9");

            Select yearSelect = new Select(driver.findElement(By.cssSelector("year")));
            yearSelect.selectByValue("1992");

            System.out.println("asd123dsf@gmail.com");
        }

        @After
        public void tearDown(){
            driver.close();
            driver.quit();
        }
    }
}
