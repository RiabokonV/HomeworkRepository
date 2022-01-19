package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select[@id='main-size-select-0']/option[4]")
    private WebElement selectSizeButton;

    @FindBy(xpath = "//button[@id='product-add-button']")
    private WebElement addToBagButton;

    @FindBy(xpath = "//button[@data-testid='miniBagIcon']")
    private WebElement bagButton;

    @FindBy(xpath = "//button[@class='i5hAj _5AuCN']")
    private WebElement saveForLaterButton;

    @FindBy(xpath = "//div[@class='product-hero']/h1")
    private WebElement productName;

    @FindBy(xpath = "//span[@class='_1z5n7CN']")
    private WebElement bagItemCounter;

    @FindBy(xpath = "//div[@class='colour-size size-component']/div[@class='size-section']/div[@class='colour-size-select']/select")
    private WebElement sizeButton;

    @FindBy(xpath = "//a[@href='https://www.asos.com/saved-lists/?nlid=nav header']")
    private WebElement saveForLaterPage;

    public WebElement getBagItemCounter() {
        return bagItemCounter;
    }

    public void clickOnSaveForLaterPage() {
        saveForLaterPage.click();
    }

    public String getProductName() {
        return productName.getText();
    }

    public WebElement getSizeButton() {
        return sizeButton;
    }

    public void clickOnBagButton() {
        bagButton.click();
    }

    public void clickSelectSizeButton() {
        sizeButton.click();
        waitVisibilityOfElement(10, getSelectSizeButton());
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", selectSizeButton);
        selectSizeButton.click();
    }

    public WebElement getSelectSizeButton() {
        return selectSizeButton;
    }

    public WebElement getBagButton() {
        return bagButton;
    }

    public void clickAddToBagButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", addToBagButton);
    }

    public void clickSaveForLaterButton() {
        saveForLaterButton.click();
    }
}
