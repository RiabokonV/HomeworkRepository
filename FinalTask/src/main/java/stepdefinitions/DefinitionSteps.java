package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {
    WebDriver driver;
    Actions actions;
    HomePage homePage;
    LogInPage logInPage;
    ProductPage productPage;
    SearchResultsPage searchResultsPage;
    ShoesViewAllPage shoesViewAllPage;
    PageFactoryManager pageFactoryManager;
    SaveForLaterPage saveForLaterPage;

    @Before
    public void setUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User open {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User check buttons visibility")
    public void userCheckButtonsVisibility() {
        homePage.waitVisibilityOfElement(30, homePage.getMenButton());
        homePage.waitVisibilityOfElement(30, homePage.getWomenButton());
    }

    @When("User click menButton")
    public void userClickMenButton() {
        homePage.clickMenButton();
    }

    @And("User see men products {string}")
    public void userSeeMenProductsMenURL(String url) {
        Assert.assertTrue(driver.getCurrentUrl().contains(url));
    }

    @When("User click womenButton")
    public void userClickWomenButton() {
        homePage.clickWomenButton();
    }

    @Then("User see women products {string}")
    public void userSeeWomenProductsWomenURL(String url) {
        Assert.assertTrue(driver.getCurrentUrl().contains(url));
    }

    @And("User check search field visibility")
    public void userCheckSearchFieldVisibility() {
        homePage.waitVisibilityOfElement(30, homePage.getSearchField());
    }

    @And("User makes search by {string}")
    public void userMakesSearchByKeyword(String keyword) {
        homePage.fillSearchField(keyword);
    }

    @When("User click search button")
    public void userClickSearchButton() {
        homePage.clickSearchButton();
    }

    @Then("User see products contains {string}")
    public void userSeeProductsContainsKeyword(String keyword) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForAjaxToComplete(10);
        searchResultsPage.waitForPageLoad(10);
        searchResultsPage.checkKeyWordInProductList(keyword);
    }

    @When("User click key{string} in search field")
    public void userClickKeyInSearchField(String arg0) {
        homePage.getSearchField().sendKeys(Keys.RETURN);
    }

    @Then("User see product page with {string}")
    public void userSeeProductPageWithProductName(String keyword) {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoad(30);
        Assert.assertTrue(productPage.getProductName().contains(keyword));
    }

    @And("User click shoes view all button")
    public void userClickShoesViewAllButton() {
        homePage.waitForPageLoad(5);
        homePage.clickShoesViewAllButton();
    }

    @When("User click on color filter black")
    public void userClickOnColorFilter() {
        shoesViewAllPage = pageFactoryManager.getShoesViewAllPage();
        shoesViewAllPage.waitVisibilityOfElement(30, shoesViewAllPage.getFilterButton());
        shoesViewAllPage.clickBlackFilterButton();
        shoesViewAllPage.waitForPageLoad(5);
    }

    @And("User click add to bag button")
    public void userClickAddToBagButton() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickAddToBagButton();
    }

    @Then("User see that amount of products in bag are {string}")
    public void userSeeThatAmountOfProductsInBagAreExpectedAmount(String expectedCount) {
        productPage.waitForPageLoad(10);
        productPage.waitForAjaxToComplete(10);
        productPage.waitVisibilityOfElement(10, productPage.getBagButton());
        productPage.clickOnBagButton();
        Assert.assertEquals(productPage.getBagItemCounter().getText(), expectedCount);
    }

    @And("User chose available size of product")
    public void userChoseAvailableSizeOfProduct() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoad(10);
        productPage.waitForAjaxToComplete(10);
        productPage.waitVisibilityOfElement(10, productPage.getSizeButton());
        productPage.clickSelectSizeButton();
    }

    @And("User click save for later button")
    public void userClickSaveForLaterButton() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickSaveForLaterButton();
    }

    @And("User click save for later page")
    public void userClickSaveForLaterPage() {
        productPage.clickOnSaveForLaterPage();
    }

    @Then("User see save products contains {string}")
    public void userSeeSaveProductsContainsExpectedName(String keyword) {
        saveForLaterPage = pageFactoryManager.getSaveForLaterPage();
        saveForLaterPage.checkSaveProductsContains(keyword);
    }

    @And("User click to add more button")
    public void userClickToAddMoreButton() {
        shoesViewAllPage = pageFactoryManager.getShoesViewAllPage();
        shoesViewAllPage.waitForPageLoad(10);
        shoesViewAllPage.waitForAjaxToComplete(10);
        shoesViewAllPage.clickLoadMoreButton();
    }

    @Then("User see {string} of products")
    public void userSeeAmountOfProducts(String amount) {
        shoesViewAllPage.waitForPageLoad(10);
        Assert.assertTrue(shoesViewAllPage.getProductsCounter().getText().contains(amount));
    }

    @Then("User see product contains {string}")
    public void userSeeProductContainsKeyword(String keyword) {
        shoesViewAllPage.waitForPageLoad(10);
        Assert.assertTrue(driver.getCurrentUrl().contains(keyword));
    }

    @And("User click to signIn button")
    public void userClickToSignInButton() {
        homePage.clickUserSignUpButton();
    }

    @When("User give incorrect email {string}")
    public void userGiveIncorrectEmail(String invalidEmail) {
        logInPage = pageFactoryManager.getLogInPage();
        logInPage.fillEmailField(invalidEmail);
    }

    @Then("User see email error message")
    public void userSeeEmailErrorMessage() {
        logInPage.waitForPageLoad(10);
        Assert.assertTrue(logInPage.getEmailError().isDisplayed());
    }

    @And("User click sign button")
    public void userClickSignButton() {

        logInPage.clickSignInButton();
    }

    @When("User give incorrect password")
    public void userGiveIncorrectPassword() {
        logInPage = pageFactoryManager.getLogInPage();
        logInPage.leavePasswordFieldEmpty();
    }

    @Then("User see password error message")
    public void userSeePasswordErrorMessage() {
        logInPage.waitForPageLoad(10);
        Assert.assertTrue(logInPage.getPasswordFieldError().isDisplayed());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
