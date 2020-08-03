import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BorisKovacevic {

        public static WebDriver driver;
        String URL = "http://automationpractice.com/index.php";


    //Helper methods
        public <ExpectedURL> void assertionPage(String ExpectedURL) {
            String ActualURL = driver.getCurrentUrl();
            Assert.assertEquals(ExpectedURL, ActualURL);
        }
        public <element, x> boolean assertionField(String element) {
            String expectedColorCodeInRGB = "rgba(53, 179, 63, 1)";
            String actual = driver.findElement(new By.ByCssSelector(element)).getCssValue("color");
            Assert.assertEquals(expectedColorCodeInRGB, actual);
            return true;
        }
        public String mailGenerator() {
            Random r = new Random();
            int rand = r.nextInt(5001);
            String mail = "wowo" + rand + "@gmail.com";
            return mail;
        }
        /*public <p> Object dataInput (String p){
            Random r = new Random();
            String[] names = {"John", "Bob", "Mark", "George", "Mike", "Sam"};
            String[] lastnames = {"Smith", "Jackson", "Myers", "Watson", "Carter"};
            int name = r.nextInt(names.length);
            int lastname = r.nextInt(names.length);
            int pass = name + lastname;
            if (p == "name"){
                return name;
            }
            if (p == "lastname"){
                return lastname;
            }
            if (p == "pass") {
                return pass;
            }
            else{
                return null;
            }
        }*/

        
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
            //Main page
            driver.findElement(By.cssSelector(".login")).click();
            Thread.sleep(1000);

            //Login page
            //Page validation
            assertionPage("http://automationpractice.com/index.php?controller=authentication&back=my-account");

            driver.findElement(By.cssSelector("#email_create")).clear();
            driver.findElement(By.cssSelector("#email_create")).sendKeys(mailGenerator());
            driver.findElement(By.cssSelector("#email")).click();
            Thread.sleep(2000);

            //Field validation
            if (assertionField("#email_create") && !driver.findElement(By.cssSelector("#create_account_error")).isDisplayed()){
                driver.findElement(By.cssSelector("#SubmitCreate")).click();
            }
            else {
                driver.findElement(By.cssSelector("#email_create")).sendKeys(mailGenerator());
                driver.findElement(By.cssSelector("#email")).click();
            }

            Thread.sleep(3000);

            //Registration page
            assertionPage("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");

            driver.findElement(By.cssSelector("#id_gender1")).click();
            driver.findElement(By.cssSelector("#customer_firstname")).clear();
            driver.findElement(By.cssSelector("#customer_firstname")).sendKeys("John");
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#customer_lastname")).sendKeys("Doe");
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#passwd")).sendKeys("passwd");
            Thread.sleep(1000);
            Select dayselect = new Select(driver.findElement(By.cssSelector("#days")));
            dayselect.selectByIndex(6);
            Thread.sleep(1000);
            Select monthselect = new Select(driver.findElement(By.cssSelector("#months")));
            monthselect.selectByIndex(3);
            Thread.sleep(1000);
            Select yearselect = new Select(driver.findElement(By.cssSelector("#years")));
            yearselect.selectByIndex(1);
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#newsletter")).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#optin")).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#company")).sendKeys("GamIng Inc.");
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#address1")).sendKeys("221B Baker Street");
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#city")).sendKeys("London");
            Thread.sleep(1000);

            assertionField("#customer_firstname");
            assertionField("#customer_lastname");
            assertionField("#passwd");

            Select stateselect = new Select(driver.findElement(By.cssSelector("#id_state")));
            stateselect.selectByIndex(14);
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#postcode")).sendKeys("11000");
            Thread.sleep(1000);
            Select countryselect = new Select(driver.findElement(By.cssSelector("#id_country")));
            countryselect.selectByIndex(1);
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#other")).sendKeys("QAItive");
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#phone_mobile")).sendKeys("067223223");
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#submitAccount")).click();
            Thread.sleep(3000);

            //Account page
            assertionPage("http://automationpractice.com/index.php?controller=my-account");
            driver.findElement(By.cssSelector(".logout")).click();
            Thread.sleep(2000);

        }
        @After
        public void tearDown(){
            driver.close();
            driver.quit();
        }
    }

