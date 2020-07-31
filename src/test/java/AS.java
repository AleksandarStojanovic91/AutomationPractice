import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AS {
    public static WebDriver driver;
    String URL = "http://automationpractice.com/index.php";
    Random r = new Random();
    int rand = r.nextInt(5001);
    String email = "testEmailForSelenium+"+rand+"@gmail.com";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @Test
    public void registerToAutomationPractice() throws InterruptedException {
        driver.findElement(By.cssSelector(".login")).click();
        driver.findElement(By.cssSelector("#email")).clear();
        driver.findElement(By.cssSelector("#email_create")).sendKeys(email);
        driver.findElement(By.cssSelector("#SubmitCreate")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#id_gender1")).click();
        driver.findElement(By.cssSelector("#customer_firstname")).sendKeys("Ime");
        driver.findElement(By.cssSelector("#customer_lastname")).sendKeys("Prezime");
        driver.findElement(By.cssSelector("#email")).clear();
        driver.findElement(By.cssSelector("#email")).sendKeys(email);
        driver.findElement(By.cssSelector("#passwd")).sendKeys("qqqqw");
        Thread.sleep(5000);
        System.out.println(email);
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();

        //kmentarafgfdhgfhsrdtf
        //
        //fdsfdfhgjk
        //

    }
}