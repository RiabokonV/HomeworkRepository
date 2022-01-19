import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@class='sidebar-list sidebar-list--fl']/li/a[@href='https://avic.ua/apple-store']")
    private WebElement appleButton;

    @FindBy(xpath = "//ul[@class='sidebar-list sidebar-list--fl']/li/a[@href='https://avic.ua/game-zone']")
    private WebElement gameZoneButton;

    @FindBy(xpath = "//li[@class='has-dropdown']/a[@class='header-top__item']")
    private WebElement languageButton;

    @FindBy(xpath = "//ul[@class='menu-dropdown menu-dropdown__lang']//a")
    private WebElement changeLanguageButton;

    @FindBy(xpath = "//a[@class='header-top__item or-color js_addMessage_btn']")
    private WebElement textToLanguageTest;

    @FindBy(xpath = "//div[@class='header-bottom__cart active-cart flex-wrap middle-xs js-btn-open']")
    private WebElement cartButton;

    @FindBy(xpath = "//div[@class='modal-g cartModal fancybox-content']/div[@data-cart-name='modal']/div[@class='cart-parent']/p/b")
    private WebElement emptyCartText;

    @FindBy(xpath = "//a[@class='main-btn  main-btn--green']")
    private WebElement acceptOrderButton;

    @FindBy(xpath = "//div[@class='ttl js_title']")
    private WebElement cartTitleText;

    public WebElement getAppleButton() {
        return appleButton;
    }

    public WebElement getGameZoneButton() {
        return gameZoneButton;
    }

    public WebElement getLanguageButton() {
        return languageButton;
    }

    public WebElement getChangeLanguageButton() {
        return changeLanguageButton;
    }

    public WebElement getTextToLanguageTest() {
        return textToLanguageTest;
    }

    public WebElement getCartButton() {
        return cartButton;
    }

    public WebElement getEmptyCartText() {
        return emptyCartText;
    }

    public WebElement getAcceptOrderButton() {
        return acceptOrderButton;
    }

    public WebElement getCartTitleText() {
        return cartTitleText;
    }
}
