import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AleksandarKrstekanic {
    public static WebDriver driver;
    String URL = "http://automationpractice.com/index.php";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @Test
    public void registrationAutomationPractice() throws InterruptedException {
        driver.findElement(By.cssSelector(".login")).click();
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("#email_create")).clear();
        driver.findElement(By.cssSelector("#email_create")).sendKeys("ajshdh@gmail.com");
        Thread.sleep(5000);

        driver.findElement(By.cssSelector(".btn.btn-default.button.button-medium.exclusive")).click();

        driver.findElement(By.cssSelector("#id_gender1")).click();

        driver.findElement(By.cssSelector("#customer_firstname")).clear();
        driver.findElement(By.cssSelector("#customer_firstname")).sendKeys("Aleksandar");

        driver.findElement(By.cssSelector("#customer_lastname")).clear();
        driver.findElement(By.cssSelector("#customer_lastname")).sendKeys("Krstekanic");

        driver.findElement(By.cssSelector("#email")).clear();
        driver.findElement(By.cssSelector("#email")).sendKeys("ajshdh@gmail.com");

        driver.findElement(By.cssSelector("#passwd")).clear();
        driver.findElement(By.cssSelector("#passwd")).sendKeys("qqqqq");

        Select daySelect = new Select(driver.findElement(By.cssSelector("#days")));
        daySelect.selectByValue("1");

        Select monthSelect = new Select(driver.findElement(By.cssSelector("#months")));
        monthSelect.selectByValue("2");

        Select yearSelect = new Select(driver.findElement(By.cssSelector("#years")));
        yearSelect.selectByValue("1982");

        driver.findElement(By.cssSelector("#newsletter")).click();
        driver.findElement(By.cssSelector("#optin")).click();

        driver.findElement(By.cssSelector("#firstname")).clear();
        driver.findElement(By.cssSelector("#firstname")).sendKeys("Aleksandar");

        driver.findElement(By.cssSelector("#lastname")).clear();
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Krstekanic");

        driver.findElement(By.cssSelector("#address1")).clear();
        driver.findElement(By.cssSelector("#address1")).sendKeys("Ulica 1");

        driver.findElement(By.cssSelector("#city")).clear();
        driver.findElement(By.cssSelector("#city")).sendKeys("Belgrade");

        Select state = new Select(driver.findElement(By.cssSelector("#id_state")));
        state.selectByVisibleText("Alabama");

        driver.findElement(By.cssSelector("#postcode")).clear();
        driver.findElement(By.cssSelector("#postcode")).sendKeys("11000");

        Select country = new Select((driver.findElement(By.cssSelector("#id_country"))));
        country.selectByValue("21");

        driver.findElement(By.cssSelector("#phone_mobile")).clear();
        driver.findElement(By.cssSelector("#phone_mobile")).sendKeys("011123456");

        Thread.sleep(5000);

        driver.findElement(By.cssSelector("#submitAccount"));
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}