import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class noParamsTestNgRobert {

    public static WebDriver driver;
    String URL = "http://www.google.com";
    String search1 = "Selenium";
    String search2 = "TestNG";

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @Test
    public void search1(){
        driver.get(URL);
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(search1);
        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();
    }

    @Test
    public void search2(){
        driver.get(URL);
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(search2);
        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
