import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class PlayStationPage extends BasePage {

    public PlayStationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='row js_height-block category-brand-parent']/div[@class='height brand-box']/div/div/a[@href='https://avic.ua/igrovie-pristavki']")
    private WebElement playStationButton;

    @FindBy(xpath = "//div[@class='filter__items checkbox']/div[@class='filter-area js_filter_parent']/label[@for='fltr-seriya-linejka-playstation-5']")
    private WebElement playStation5filter;

    public List<WebElement> getProductList() {
        return getDriver().findElements(xpath("//div[@class='prod-cart__descr']"));
    }

    public WebElement getPlayStationButton() {
        return playStationButton;
    }

    public WebElement getPlayStation5filter() {
        return playStation5filter;
    }
}
