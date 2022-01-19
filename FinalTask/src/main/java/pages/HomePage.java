package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//form[@data-testid='search-form']//input")
    private WebElement searchField;

    @FindBy(xpath = "//a[@href='https://my.asos.com/my-account?lang=en-GB&store=ROW&country=UA&keyStoreDataversion=hgk0y12-29']")
    private WebElement userSignInButton;

    @FindBy(xpath = "//ul[@class='_1PXCics']/li/a[@href='https://www.asos.com/men/shoes-boots-trainers/cat/?cid=4209&nlid=mw|shoes|shop+by+product|view+all']")
    private WebElement shoesViewAllButton;

    @FindBy(xpath = "//div[@class='h-7-BEq']/button")
    private WebElement searchButton;

    @FindBy(xpath = "//ul[@class='_1gfpvjl _2Q6RfP3']/li/a[@href='https://www.asos.com/men/']")
    private WebElement menButton;

    @FindBy(xpath = "//ul[@class='_1gfpvjl _2Q6RfP3']/li/a[@href='https://www.asos.com/women/']")
    private WebElement womenButton;

    @FindBy(xpath = "//button[@data-id='87a52035-f6fa-401f-bd58-0d259e403cbb']")
    private WebElement shoesButton;

    @FindBy(xpath = "//button[@data-testid='myAccountIcon']")
    private WebElement userButton;

    public WebElement getShoesButton() {
        return shoesButton;
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public WebElement getShoesViewAllButton() {
        return shoesViewAllButton;
    }

    public void fillSearchField(String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public void clickMenButton() {
        menButton.click();
    }

    public void clickWomenButton() {
        womenButton.click();
    }

    public WebElement getUserSignInButton() {
        return userSignInButton;
    }

    public void clickUserSignUpButton() {
        userButton.click();
        waitVisibilityOfElement(10, getUserSignInButton());
        userSignInButton.click();
    }

    public void clickShoesViewAllButton() {
        shoesButton.click();
        shoesViewAllButton.click();
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public WebElement getMenButton() {
        return menButton;
    }

    public WebElement getWomenButton() {
        return womenButton;
    }

    public WebElement getSearchField() {
        return searchField;
    }
}
