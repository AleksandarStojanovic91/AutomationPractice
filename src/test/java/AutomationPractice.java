import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import javax.swing.*;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AutomationPractice {
    public static WebDriver driver;
    String URL = "http://automationpractice.com/index.php";
    Random r = new Random();
    int rand = r.nextInt(5001);
    int num1 = r.nextInt(99999);
    int num2 = r.nextInt(9999);
    String phone = String.valueOf(num1)+String.valueOf(num2);

    String email = "testEmailForSelenium+"+rand+"@gmail.com";
    String TShirts = "ul.sf-menu.clearfix.menu-content.sf-js-enabled.sf-arrows>li>[title=\"T-shirts\"]";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @Test
    public void registerToAutomationPractice(){

        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement loginButton = driver.findElement(By.cssSelector(".login"));


        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();

        driver.findElement(By.cssSelector("#email")).clear();
        driver.findElement(By.cssSelector("#email_create")).sendKeys(email);
        driver.findElement(By.cssSelector("#SubmitCreate")).click();
        driver.findElement(By.cssSelector("#id_gender1")).click();
        driver.findElement(By.cssSelector("#customer_firstname")).clear();
        driver.findElement(By.cssSelector("#customer_firstname")).sendKeys("Ime");
        driver.findElement(By.cssSelector("#customer_lastname")).clear();
        driver.findElement(By.cssSelector("#customer_lastname")).sendKeys("Prezime");
        driver.findElement(By.cssSelector("#email")).clear();
        driver.findElement(By.cssSelector("#email")).sendKeys(email);
        driver.findElement(By.cssSelector("#passwd")).clear();
        driver.findElement(By.cssSelector("#passwd")).sendKeys("qqqqw");
        Select daySelect = new Select(driver.findElement(By.cssSelector("#days")));
        daySelect.selectByValue("10");
        Select monthSelect = new Select(driver.findElement(By.cssSelector("#months")));
        monthSelect.selectByValue("8");
        Select yearSelect = new Select(driver.findElement(By.cssSelector("#years")));
        yearSelect.selectByValue("2007");
        driver.findElement(By.cssSelector("[name|=\"firstname\"]")).clear();
        driver.findElement(By.cssSelector("[name|=\"firstname\"]")).sendKeys("Ime");
        driver.findElement(By.cssSelector("[name|=\"lastname\"]")).clear();
        driver.findElement(By.cssSelector("[name|=\"lastname\"]")).sendKeys("Prezime");
        driver.findElement(By.cssSelector("#company")).sendKeys("qweasd");
        driver.findElement(By.cssSelector("#address1")).sendKeys("Ulica 12");
        driver.findElement(By.cssSelector("#address2")).sendKeys("Adresa 123");
        driver.findElement(By.cssSelector("#city")).sendKeys("Beograd");
        Select stateSelect = new Select(driver.findElement(By.cssSelector("#id_state")));
        stateSelect.selectByValue("11");
        driver.findElement(By.cssSelector("#postcode")).sendKeys("11000");
        Select countrySelect = new Select(driver.findElement(By.cssSelector("#id_country")));
        countrySelect.selectByValue("21");
        driver.findElement(By.cssSelector("#other")).sendKeys("other");
        driver.findElement(By.cssSelector("#phone")).sendKeys(" ");
        driver.findElement(By.cssSelector("#phone_mobile")).sendKeys(phone);
        driver.findElement(By.cssSelector("#alias")).clear();
        driver.findElement(By.cssSelector("#alias")).sendKeys("Neki alias qwe");
        driver.findElement(By.cssSelector("#submitAccount")).click();

        String textIzPoljaImePrezime = driver.findElement(By.cssSelector(".account>span")).getText();
        String boja = driver.findElement(By.cssSelector(".icon-heart")).getCssValue("font-family");
        Assert.assertEquals("Ime Prezime",textIzPoljaImePrezime);
        Assert.assertEquals("FontAwesome",boja);
        Assert.assertTrue(driver.findElement(By.cssSelector(".icon-heart")).isDisplayed());
        //Assert.assertFalse(!driver.findElement(By.cssSelector(".icon-heart")).isDisplayed());


        driver.findElement(By.cssSelector(TShirts)).click();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector("a.product_img_link>.replace-2x.img-responsive"))).perform();
        driver.findElement(By.cssSelector(".button.ajax_add_to_cart_button.btn.btn-default>span")).click();

        driver.findElement(By.cssSelector("div.button-container>.btn.btn-default.button.button-medium>span")).click();
        driver.findElement(By.cssSelector(".button.btn.btn-default.standard-checkout.button-medium>span")).click();
        driver.findElement(By.cssSelector("button.button.btn.btn-default.button-medium")).click();

        driver.findElement(By.id("cgv")).click();
        driver.findElement(By.cssSelector(".button.btn.btn-default.standard-checkout.button-medium")).click();

        driver.findElement(By.cssSelector("[Title=\"Pay by bank wire\"]")).click();
        driver.findElement(By.cssSelector("button.button.btn.btn-default.button-medium")).click();
        driver.findElement(By.cssSelector(".logout")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector(".login")).isDisplayed());

    }

    @Test
    public void enterEmailAndClickRegister(){

        driver.findElement(By.cssSelector(".login")).click();

        driver.findElement(By.cssSelector("#email")).clear();
        driver.findElement(By.cssSelector("#email_create")).sendKeys("email@email.com");

        driver.findElement(By.cssSelector("#SubmitCreate")).click();
    }

    @Test
    public void kupovinaHaljina(){
        driver.findElement(By.xpath("//body[@id='index']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a[1]")).click();

        int listSize = driver.findElements(By.cssSelector(".product_list.grid.row>li")).size();
        System.out.println(listSize);

        for(int i = 1;i <= listSize;i++){
            driver.findElement(By.cssSelector(".product_list.grid.row>li:nth-child("+i+")>div>div.right-block>h5"));
        }

    }

    @Test
    public void KontaktBezSubject(){
        driver.findElement(By.cssSelector("#contact-link>a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("nekimail@gmail.com");
        driver.findElement(By.cssSelector("#id_order")).sendKeys("54654654");
        driver.findElement(By.cssSelector("#message")).sendKeys("Poruka.......");
        driver.findElement(By.cssSelector("#submitMessage")).click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector(".alert.alert-danger>ol>li")),"Please select a subject from the list provided."));


        Assert.assertEquals(driver.findElement(By.cssSelector(".alert.alert-danger>ol>li")).getText(),"Please select a subject from the list provided.");
    }

    @Test
    public void KontaktSaSubject(){
        Select kontakt = new Select(driver.findElement(By.cssSelector("#id_contact")));
        kontakt.selectByValue("2");

        driver.findElement(By.cssSelector("#contact-link>a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("nekimail@gmail.com");
        driver.findElement(By.cssSelector("#id_order")).sendKeys("54654654");
        driver.findElement(By.cssSelector("#message")).sendKeys("Poruka.......");
        driver.findElement(By.cssSelector("#submitMessage")).click();
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}