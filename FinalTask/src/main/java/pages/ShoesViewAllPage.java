package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoesViewAllPage extends BasePage {
    public ShoesViewAllPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[@data-auto-id='productsProgressBar']")
    private WebElement productsCounter;

    @FindBy(xpath = "//div[@class='_13zmyd6']/a[@href='https://www.asos.com/men/shoes-boots-trainers/cat/?cid=4209&page=2']")
    private WebElement loadMoreButton;

    @FindBy(xpath = "//li[@data-dropdown-id='base_colour']/div[@class='_1O2ljAn']/button[@class='_1om7l06']")
    private WebElement filterButton;

    @FindBy(xpath = "//label[@for='base_colour_4']/div[@class='kx2nDmW']")
    private WebElement blackFilterButton;


    public WebElement getFilterButton() {
        return filterButton;
    }

    public WebElement getProductsCounter() {
        return productsCounter;
    }

    public void clickBlackFilterButton() {
        filterButton.click();
        waitVisibilityOfElement(10, blackFilterButton);
        blackFilterButton.click();
    }

    public List<WebElement> getProductsList() {
        return driver.findElements(By.xpath("//div[@class='_3J74XsK']/div/h2"));
    }

    public void clickLoadMoreButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loadMoreButton);
    }

    public WebElement getLoadMoreButton() {
        return loadMoreButton;
    }

    public WebElement getBlackFilterButton() {
        return blackFilterButton;
    }

}
