import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
        driver.findElement(By.cssSelector("#id_gender1")).click();

        driver.findElement(By.cssSelector("#customer_firstname")).clear();
        driver.findElement(By.cssSelector("#customer_firstname")).sendKeys("test");

        driver.findElement(By.cssSelector("#customer_lastname")).clear();
        driver.findElement(By.cssSelector("#customer_lastname")).sendKeys("test");

        driver.findElement(By.cssSelector("#email")).clear();
        driver.findElement(By.cssSelector("#email")).sendKeys("testkgms@gmail.com");

        driver.findElement(By.cssSelector("#passwd")).clear();
        driver.findElement(By.cssSelector("#passwd")).sendKeys("534321");

        Select daySelect = new Select(driver.findElement(By.cssSelector("#days")));
        daySelect.selectByValue("13");

        Select monthsSelect = new Select(driver.findElement(By.cssSelector("#months")));
        monthsSelect.selectByValue("2");


        Select yearsSelect = new Select(driver.findElement(By.cssSelector("#years")));
        yearsSelect.selectByValue("1991");

        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='firstname']")).clear();
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("test");

        driver.findElement(By.xpath("//input[@id='lastname']")).clear();
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("test");

        driver.findElement(By.cssSelector("#company")).clear();
        driver.findElement(By.cssSelector("#company")).sendKeys("address");

        driver.findElement(By.cssSelector("#address1")).clear();
        driver.findElement(By.cssSelector("#address1")).sendKeys("address");

        driver.findElement(By.cssSelector("#address2")).clear();
        driver.findElement(By.cssSelector("#address2")).sendKeys("17");

        driver.findElement(By.cssSelector("#city")).clear();
        driver.findElement(By.cssSelector("#city")).sendKeys("city");

        Thread.sleep(5000);
        Select state = new Select(driver.findElement(By.cssSelector("#id_state")));
        state.selectByValue("51");

        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#postcode")).clear();
        driver.findElement(By.cssSelector("#postcode")).sendKeys("00601");

        Thread.sleep(5000);
        Select country = new Select(driver.findElement(By.cssSelector("#id_country")));
        country.selectByValue("21");

        driver.findElement(By.cssSelector("#other")).clear();
        driver.findElement(By.cssSelector("#other")).sendKeys("other");

        driver.findElement(By.cssSelector("#phone")).clear();
        driver.findElement(By.cssSelector("#phone")).sendKeys("123456");

        driver.findElement(By.cssSelector("#phone_mobile")).clear();
        driver.findElement(By.cssSelector("#phone_mobile")).sendKeys("456123");

        driver.findElement(By.cssSelector("#alias")).clear();
        driver.findElement(By.cssSelector("#alias")).sendKeys("alias");

        driver.findElement(By.cssSelector("#submitAccount")).click();
        
        Thread.sleep(5000);


    }


    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }




}
