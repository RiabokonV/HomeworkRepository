import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {
    private static final String AVIC_URL = "https://avic.ua/";

    private WebDriver driver;

    @BeforeTest
    public void chromeProfileSetUp() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testPreparation() {
        String closeButtonXpath = "//div[@class='modal-g popUpModal fancybox-content']/button";
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AVIC_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(closeButtonXpath)));
        driver.findElement(By.xpath(closeButtonXpath)).click();
    }

    @AfterMethod
    public void testEnding() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public PlayStationPage getPlayStationPage() {
        return new PlayStationPage(getDriver());
    }


}
