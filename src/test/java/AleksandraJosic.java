import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AleksandraJosic {

    public static WebDriver driver;
    String URL = "http://automationpractice.com/index.php";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
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
        driver.findElement(By.cssSelector("#email_create")).sendKeys("testkgms@gmail.com");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#SubmitCreate")).click();
        Thread.sleep(5000);

    }


    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }




}
