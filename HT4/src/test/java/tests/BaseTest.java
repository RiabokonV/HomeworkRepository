package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.ProductPage;
import utils.CapabilityFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    private CapabilityFactory capabilityFactory = new CapabilityFactory();

    private static final String ROZETKA_URL = "https://rozetka.com.ua/";

    public WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        driver.set(new RemoteWebDriver(new URL("http://192.168.0.102:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
        getDriver().manage().window().maximize();
        getDriver().get(ROZETKA_URL);
    }

    @AfterMethod
    public void tearDown() {
        getDriver().close();
    }

    @AfterClass
    public void terminate() {
        driver.remove();
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public ProductPage getProductPage() {
        return new ProductPage(getDriver());
    }

}
