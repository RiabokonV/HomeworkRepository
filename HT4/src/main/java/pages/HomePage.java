package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@class='search-form__input-wrapper']/input")
    private WebElement searchField;

    @FindBy(xpath = "//li[@class='header-actions__item header-actions__item--user']/rz-user/button[@class='header__button ng-star-inserted']")
    private WebElement userButton;

    @FindBy(xpath = "//div[@class='form__row validation_type_error']/p")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@class='form__row']/input[@class='ng-untouched ng-pristine ng-invalid']")
    private WebElement emailField;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void fillEmailField(String invalidText) {
        emailField.sendKeys(invalidText, Keys.RETURN);
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public void clickUserButton() {
        userButton.click();
    }


    public void fillSearchField(String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText, Keys.RETURN);
    }


}
