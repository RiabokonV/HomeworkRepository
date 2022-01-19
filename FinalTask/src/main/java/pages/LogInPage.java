package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {
    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='Username']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='submit']/input")
    private WebElement signInButton;

    @FindBy(xpath = "//span[@id='EmailAddress-error']")
    private WebElement emailError;

    @FindBy(xpath = "//span[@id='Password-error']")
    private WebElement passwordFieldError;

    public void fillEmailField(String textToEnter) {
        emailField.clear();
        emailField.sendKeys(textToEnter);
    }

    public void leavePasswordFieldEmpty() {
        passwordField.click();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public WebElement getEmailError() {
        return emailError;
    }

    public WebElement getPasswordFieldError() {
        return passwordFieldError;
    }
}
