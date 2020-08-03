import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AleksandarKrstekanic {
    public static WebDriver driver;
    String URL = "http://automationpractice.com/index.php";
    Random r = new Random();
    int rand = r.nextInt(5001);
    int phone = r.nextInt(5001);
    int num1 = r.nextInt(99999);
    int num2 = r.nextInt(99999);
    String email = "testEmailForSelenium+"+rand+"@gmail.com";
    String TShirts = "ul.sf-menu.clearfix.menu-content.sf-js-enabled.sf-arrows>li>[title=\"T-shirts\"]";
    String mobPhone = String.valueOf(num1) + String.valueOf(num2);

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(URL);

    }

//    @Test
//    public void registrationAutomationPractice() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver,20);
//        WebElement loginButton  = driver.findElement(By.cssSelector(".login"));
//
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".login"))));
//        loginButton.click();
//
////        driver.findElement(By.cssSelector(".login")).click();
//        Thread.sleep(5000);
//
//        driver.findElement(By.cssSelector("#email_create")).clear();
//        driver.findElement(By.cssSelector("#email_create")).sendKeys(email);
//        Thread.sleep(5000);
//
//        driver.findElement(By.cssSelector(".btn.btn-default.button.button-medium.exclusive")).click();
//
////        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#id_gender1"))));
//        driver.findElement(By.cssSelector("#id_gender1")).click();
//
//        driver.findElement(By.cssSelector("#customer_firstname")).clear();
//        driver.findElement(By.cssSelector("#customer_firstname")).sendKeys("Aleksandar");
//
//        driver.findElement(By.cssSelector("#customer_lastname")).clear();
//        driver.findElement(By.cssSelector("#customer_lastname")).sendKeys("Krstekanic");
//
//        driver.findElement(By.cssSelector("#email")).clear();
//        driver.findElement(By.cssSelector("#email")).sendKeys(email);
//
//        driver.findElement(By.cssSelector("#passwd")).clear();
//        driver.findElement(By.cssSelector("#passwd")).sendKeys("qqqqq");
//
//        Select daySelect = new Select(driver.findElement(By.cssSelector("#days")));
//        daySelect.selectByValue("1");
//
//        Select monthSelect = new Select(driver.findElement(By.cssSelector("#months")));
//        monthSelect.selectByValue("2");
//
//        Select yearSelect = new Select(driver.findElement(By.cssSelector("#years")));
//        yearSelect.selectByValue("1982");
//
//        driver.findElement(By.cssSelector("#newsletter")).click();
//        driver.findElement(By.cssSelector("#optin")).click();
//
//        driver.findElement(By.cssSelector("#firstname")).clear();
//        driver.findElement(By.cssSelector("#firstname")).sendKeys("Aleksandar");
//
//        driver.findElement(By.cssSelector("#lastname")).clear();
//        driver.findElement(By.cssSelector("#lastname")).sendKeys("Krstekanic");
//
//        driver.findElement(By.cssSelector("#address1")).clear();
//        driver.findElement(By.cssSelector("#address1")).sendKeys("Ulica 1");
//
//        driver.findElement(By.cssSelector("#city")).clear();
//        driver.findElement(By.cssSelector("#city")).sendKeys("Belgrade");
//
//        Select state = new Select(driver.findElement(By.cssSelector("#id_state")));
//        state.selectByVisibleText("Alabama");
//
//        driver.findElement(By.cssSelector("#postcode")).clear();
//        driver.findElement(By.cssSelector("#postcode")).sendKeys("11000");
//
//        Select country = new Select((driver.findElement(By.cssSelector("#id_country"))));
//        country.selectByValue("21");
//
//        driver.findElement(By.cssSelector("#phone_mobile")).clear();
//        driver.findElement(By.cssSelector("#phone_mobile")).sendKeys(mobPhone);
//
//        Thread.sleep(5000);
//
//        driver.findElement(By.cssSelector("#submitAccount")).click();
//
//        Thread.sleep(10000);
//
//        String textPolja = driver.findElement(By.cssSelector("*.account>span")).getText();
//
//        String boja = driver.findElement(By.cssSelector(".icon-heart")).getCssValue("color");
//        Assert.assertEquals("Aleksandar Krstekanic", textPolja);
//        Assert.assertEquals("rgba(253, 126, 1, 1)", boja );
//
//        driver.findElement(By.cssSelector(TShirts)).click();
//
//        Actions actions = new Actions(driver);
//        actions.moveToElement(driver.findElement(By.cssSelector("a.product_img_link>.replace-2x.img-responsive"))).perform();
//        driver.findElement(By.cssSelector(".button.ajax_add_to_cart_button.btn.btn-default>span")).click();
//
//        driver.findElement(By.cssSelector("div.button-container>.btn.btn-default.button.button-medium>span")).click();
//        driver.findElement(By.cssSelector(".button.btn.btn-default.standard-checkout.button-medium>span")).click();
////        driver.findElement(By.cssSelector(".button.btn.btn-default.standard-checkout.button-medium")).click();
//        driver.findElement(By.cssSelector("button.button.btn.btn-default.button-medium")).click();
//        driver.findElement(By.id("cgv")).click();
//        driver.findElement(By.cssSelector(".button.btn.btn-default.standard-checkout.button-medium")).click();
//
//        driver.findElement(By.cssSelector("[Title=\"Pay by bank wire\"]")).click();
//
//        driver.findElement(By.cssSelector("button.button.btn.btn-default.button-medium")).click();
//        driver.findElement(By.cssSelector(".logout")).click();
//
//        Assert.assertTrue(driver.findElement(By.cssSelector(".login")).isDisplayed());
//
//
//        Thread.sleep(10000);
//    }
//@Test
//public void kupovinahaljina(){
//        driver.findElement(By.xpath("//body[@id='index']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a[1]")).click();
//
//    driver.findElement(By.cssSelector(".product_list.grid.row>li:nth-child(1)>div>div.right-block>h5")).getText();
//    driver.findElement(By.cssSelector(".product_list.grid.row>li:nth-child(2)>div>div.right-block>h5")).getText();
//    driver.findElement(By.cssSelector(".product_list.grid.row>li:nth-child(3)>div>div.right-block>h5")).getText();
//    driver.findElement(By.cssSelector(".product_list.grid.row>li:nth-child(4)>div>div.right-block>h5")).getText();
//    driver.findElement(By.cssSelector(".product_list.grid.row>li:nth-child(5)>div>div.right-block>h5")).getText();
//
//    int listSize = driver.findElements(By.cssSelector(".product_list.grid.row>li")).size();
//
//    for (int i=1;i<=listSize;i++){
//        driver.findElement(By.cssSelector(".product_list.grid.row>li:nth-child(" + i + ")>div>div.right-block>h5"));
//        Assert.assertTrue(driver.findElement(By.cssSelector(".product_list.grid.row>li:nth-child(" + i + ")>div>div.right-block>h5")).isDisplayed());
//    }
////    for (int i = 1; i < 6; i++){
////        System.out.println(driver.findElement(By.cssSelector(".product_list.grid.row>li:nth-child(" + i + ")>div>div.right-block>h5")).getText());
////    }
//
//}

    @Test
    public void kontaktBezSubject(){
//        driver.findElement(By.cssSelector());
//        driver.findElement(By.cssSelector("#email")).sendKeys("nekimail@gmail.con");
//        driver.findElement(By.cssSelector("id_order")).

                WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector(".alert.alert-danger>ul>li")),"Please select a subject from the list provided."));

    }

    @Test
    public void kontaktSaSubject(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#id_contact")));

        Select kontakt = new Select(driver.findElement(By.cssSelector("#id_contact")));
        kontakt.selectByValue("2");

    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}