package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='_3J74XsK']/div/h2")
    private List<WebElement> productsList;


    public void clickOnFirstProduct() {
        productsList.get(0).click();
    }


    public void checkKeyWordInProductList(String keyword) {
        System.out.println(productsList.size());
        for (WebElement element : productsList) {
            Assert.assertTrue(element.getText().contains(keyword));
        }
    }
}
