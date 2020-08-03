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

            Select daySelect = new Select(driver.findElement(By.cssSelector("#days")));
            daySelect.selectByValue("7");

            Select monthSelect = new Select(driver.findElement(By.cssSelector("#months")));
            monthSelect.selectByValue("9");

            Select yearSelect = new Select(driver.findElement(By.cssSelector("#years")));
            yearSelect.selectByValue("1992");
            driver.findElement(By.id("firstname")).sendKeys("Milena");
            driver.findElement(By.id("lastname")).sendKeys("Janjic");
            driver.findElement(By.id("company")).sendKeys("MojaFirma");
            driver.findElement(By.id("address1")).sendKeys("Batutova");
            driver.findElement(By.id("city")).sendKeys("Belgrade");

            Select stateSelect = new Select(driver.findElement(By.id("id_state")));
            stateSelect.selectByValue("2");

            driver.findElement(By.id("postcode")).sendKeys("10000");

            Select countrySelect = new Select((driver.findElement(By.id("id_country"))));
            countrySelect.selectByValue("1");

            driver.findElement(By.id("phone_mobile")).sendKeys("061234567");
            driver.findElement(By.id("alias")).sendKeys("MojaAdresa");
            driver.findElement(By.id("submitlogin")).click();



            System.out.println("asd123dsf@gmail.com");
        }

        @After
        public void tearDown(){
            driver.close();
            driver.quit();
        }
    }
}
