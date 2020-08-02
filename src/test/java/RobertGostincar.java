import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Beta;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RobertGostincar {

    public static WebDriver driver;
    String URL = "http://automationpractice.com/index.php";
    Random r = new Random();
    int rand = r.nextInt(5001);
    String email = "testEmailForSelenium+" + rand + "@gmail.com";

    //Text data

    String emailText = "robitestemail@robitestemail.com";
    String firstName = "Robi";
    String lastName = "Robertson";
    String password = "robirobertson";
    String company = "robi company";
    String address = "Topolska 18";
    String city = "Belgrade";
    String zip = "11000";
    String homePhone = "011234567";
    String mobilePhone = "061234567";
    String addressAlias = "Ustanicka 7";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @Test
    public void testRegistration01() throws InterruptedException {
        driver.findElement(By.cssSelector(".login")).click();

        driver.findElement(By.cssSelector("#email_create")).sendKeys(emailText);
        driver.findElement(By.cssSelector("#SubmitCreate")).click();
        Thread.sleep(5000);


        driver.findElement(By.cssSelector("#id_gender1")).click();

        driver.findElement(By.cssSelector("#customer_firstname")).click();
        driver.findElement(By.cssSelector("#customer_firstname")).sendKeys(firstName);


        driver.findElement(By.cssSelector("#customer_lastname")).click();
        driver.findElement(By.cssSelector("#customer_lastname")).sendKeys(lastName);

        driver.findElement(By.cssSelector("#email")).clear();
        driver.findElement(By.cssSelector("#email")).sendKeys(emailText);

        driver.findElement(By.cssSelector("#passwd")).click();
        driver.findElement(By.cssSelector("#passwd")).sendKeys(password);

        Select daySelect = new Select(driver.findElement(By.cssSelector("#days")));
        daySelect.selectByValue("21");

        Select monthSelect = new Select(driver.findElement(By.cssSelector("#months")));
        monthSelect.selectByValue("3");

        Select yearSelect = new Select(driver.findElement(By.cssSelector("#years")));
        yearSelect.selectByValue("1990");

        Thread.sleep(5000);

        driver.findElement(By.cssSelector("#firstname")).clear();
        driver.findElement(By.cssSelector("#firstname")).sendKeys(firstName);

        driver.findElement(By.cssSelector("#lastname")).clear();
        driver.findElement(By.cssSelector("#lastname")).sendKeys(lastName);

        driver.findElement(By.cssSelector("#company")).click();
        driver.findElement(By.cssSelector("#company")).sendKeys(company);

        driver.findElement(By.cssSelector("#address1")).click();
        driver.findElement(By.cssSelector("#address1")).sendKeys(address);

        driver.findElement(By.cssSelector("#city")).click();
        driver.findElement(By.cssSelector("#city")).sendKeys(city);

        Select state = new Select(driver.findElement(By.cssSelector("#id_state")));
        state.selectByValue("2");

        driver.findElement(By.cssSelector("#postcode")).click();
        driver.findElement(By.cssSelector("#postcode")).sendKeys(zip);

        Select country = new Select(driver.findElement(By.cssSelector("#id_country")));
        country.selectByValue("21");

        driver.findElement(By.cssSelector("#phone")).click();
        driver.findElement(By.cssSelector("#phone")).sendKeys(homePhone);

        driver.findElement(By.cssSelector("#phone_mobile")).click();
        driver.findElement(By.cssSelector("#phone_mobile")).sendKeys(mobilePhone);

        driver.findElement(By.cssSelector("#alias")).click();
        driver.findElement(By.cssSelector("#alias")).sendKeys(addressAlias);

        driver.findElement(By.cssSelector("#submitAccount")).click();

        Thread.sleep(3000);
        Thread.sleep(3000);

    }

    @After
    public void exit() {
        driver.close();
        driver.quit();
    }
}