package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='buy-button button button_with_icon button_color_green button_size_large ng-star-inserted']")
    private WebElement buyButton;

    @FindBy(xpath = "//button[@class='header__button ng-star-inserted header__button--active']/rz-icon-counter/span")
    private WebElement cartCounter;

    @FindBy(xpath = "//button[@class='modal__close']")
    private WebElement closeCartButton;

    public void clickBuyButton() {
        buyButton.click();
    }

    public WebElement getCloseCartButton() {
        return closeCartButton;
    }

    public WebElement getBuyButton() {
        return buyButton;
    }

    public void clickCloseCartButton() {
        closeCartButton.click();
    }

    public Object getTextOfCounter() {

        return cartCounter.getText();
    }

}
