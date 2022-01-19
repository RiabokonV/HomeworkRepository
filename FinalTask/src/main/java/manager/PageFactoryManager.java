package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public LogInPage getLogInPage() {
        return new LogInPage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(driver);
    }

    public ShoesViewAllPage getShoesViewAllPage() {
        return new ShoesViewAllPage(driver);
    }

    public SaveForLaterPage getSaveForLaterPage(){
        return new SaveForLaterPage(driver);
    }

}
