package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SaveForLaterPage extends BasePage {
    public SaveForLaterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='productTile_KcKf2']")
    private List<WebElement> saveProducts;

    public void checkSaveProductsContains(String keyword) {
        for (WebElement element : saveProducts) {
            Assert.assertTrue(element.getText().contains(keyword));
        }
    }

}
