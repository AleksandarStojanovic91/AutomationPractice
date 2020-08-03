import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class JelenaMaric {


    public static WebDriver driver;
    String URL = "http://automationpractice.com/index.php";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @Test
    public void registerAccountPractice() throws InterruptedException {

        driver.findElement(By.cssSelector(".login")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#email_create")).clear();
        driver.findElement(By.cssSelector("#email_create")).sendKeys("qweqwe3@email.com");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#SubmitCreate")).click();
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("#id_gender2")).click();
        driver.findElement(By.cssSelector("#customer_firstname")).clear();
        driver.findElement(By.cssSelector("#customer_firstname")).sendKeys("Patak");
        driver.findElement(By.cssSelector("#customer_lastname")).clear();
        driver.findElement(By.cssSelector("#customer_lastname")).sendKeys("Daca");
        driver.findElement(By.cssSelector("#email")).clear();
        driver.findElement(By.cssSelector("#email")).sendKeys("qweqwe3@email.com");
        driver.findElement(By.cssSelector("#passwd")).sendKeys("Test123");

        Select daySelect = new Select(driver.findElement(By.cssSelector("#days")));
        daySelect.selectByValue("23");

        Select monthSelect = new Select(driver.findElement(By.cssSelector("#months")));
        monthSelect.selectByValue("2");

        Select yearSelect = new Select(driver.findElement(By.cssSelector("#years")));
        yearSelect.selectByValue("2000");

        Thread.sleep(5000);

        driver.findElement(By.cssSelector("[name|=\"firstname\"]")).clear();
        driver.findElement(By.cssSelector("[name|=\"firstname\"]")).sendKeys("Patak");
        driver.findElement(By.cssSelector("[name|=\"lastname\"]")).clear();
        driver.findElement(By.cssSelector("[name|=\"lastname\"]")).sendKeys("Daca");
        driver.findElement(By.cssSelector("#company")).sendKeys("Qweqwe company");
        driver.findElement(By.cssSelector("#address1")).sendKeys("Paje Patka 2");
        driver.findElement(By.cssSelector("#address2")).sendKeys("Blok 6, 96");
        driver.findElement(By.cssSelector("#city")).sendKeys("Manila");

        Select stateSelect = new Select(driver.findElement(By.cssSelector("#id_state")));
        stateSelect.selectByValue("14");

        driver.findElement(By.cssSelector("#postcode")).sendKeys("46295");

        Select countrySelect = new Select(driver.findElement(By.cssSelector("#id_country")));
        countrySelect.selectByValue("21");

        driver.findElement(By.cssSelector("#other")).sendKeys("test info");
        driver.findElement(By.cssSelector("#phone")).sendKeys("123123123");
        driver.findElement(By.cssSelector("#phone_mobile")).sendKeys("555666777");
        driver.findElement(By.cssSelector("#alias")).clear();
        driver.findElement(By.cssSelector("#alias")).sendKeys("Mala ulica 100");
        driver.findElement(By.cssSelector("#submitAccount")).click();
        Thread.sleep(5000);

    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();

    }
}
