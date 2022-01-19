import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.text.html.parser.Element;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.*;

public class AvicTests {


    private WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void testSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://avic.ua/");
    }

    @Test
    public void checkThatUrlContainsWords() {
        driver.findElement(By.xpath("//input[@id='input_search']"))
                .sendKeys("iPhone13");
        driver.findElement(By.xpath("//button[@class='button-reset search-btn']"))
                .click();
        String s = driver.getCurrentUrl();
        assertTrue(s.contains("query=iPhone"));
    }

    @Test(priority = 1)
    public void checkUrlFromButton() {
        driver.findElement(By.xpath("//ul[@class='sidebar-list sidebar-list--fl']/li[1]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String s = driver.getCurrentUrl();
        assertTrue(s.contains("apple-store"));
    }

    @Test(priority = 2)
    public void checkPs5Products() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(By.xpath("//ul[@class='sidebar-list sidebar-list--fl']/li[10]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row js_height-block category-brand-parent']/div[@class='height brand-box'][1]/div/div[1]/a")));
        driver.findElement(By.xpath("//div[@class='row js_height-block category-brand-parent']/div[@class='height brand-box'][1]/div/div[1]/a"))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='filter__items checkbox'][1]/div[@class='filter-area js_filter_parent'][1]/label[@for='fltr-seriya-linejka-playstation-5']")));
        driver.findElement(By.xpath("//div[@class='filter__items checkbox'][1]/div[@class='filter-area js_filter_parent'][1]/label[@for='fltr-seriya-linejka-playstation-5']"))
                .click();
        List<WebElement> elementList = driver.findElements(xpath("//div[@class='prod-cart__descr']"));
        int productsOnPage = elementList.size();
        assertEquals(productsOnPage, 3);
    }

    @Test(priority = 3)
    public void checkLanguageChange(){
        String lang1 = driver.findElement(By.xpath("//a[@class='header-top__item or-color js_addMessage_btn']")).getText();
        driver.findElement(By.xpath("//ul[@class='header-top__list header-top__right flex-wrap end-xs']/li[6]")).click();
        driver.findElement(By.xpath("//ul[@class='header-top__list header-top__right flex-wrap end-xs']/li[6]/ul")).click();
        driver.manage().timeouts().getPageLoadTimeout();
        String lang2 =  driver.findElement(By.xpath("//a[@class='header-top__item or-color js_addMessage_btn']")).getText();
        assertNotEquals(lang2, lang1); //не розумію чому мова не перемикається коли натискає на відповідну кнопку, хотілось би розібратись на лекціі
    }

    @Test(priority = 4)
    public void checkEmptyBasketAlert(){
    driver.findElement(By.xpath("//div[@class='header-bottom__cart active-cart flex-wrap middle-xs js-btn-open']")).click();
        driver.manage().timeouts().getPageLoadTimeout();
        String empty = driver.findElement(By.xpath("//div[@class='modal-g cartModal fancybox-content']/div[@data-cart-name='modal']/div[@class='cart-parent']/p/b")).getText();
        driver.findElement(By.xpath("//a[@class='main-btn  main-btn--green']")).click();
        driver.manage().timeouts().getPageLoadTimeout();
        String title = driver.findElement(By.xpath("//div[@class='ttl js_title']")).getText();
    assertEquals(title,empty);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
