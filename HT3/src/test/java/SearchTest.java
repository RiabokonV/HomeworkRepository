import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SearchTest extends BaseTest {

    @Test(priority = 1)
    public void checkUrlFromButton() {
        getHomePage().getAppleButton().click();
        assertTrue(getDriver().getCurrentUrl().contains("apple-store"));
    }

    @Test(priority = 2)
    public void checkPS5Products() {
        getHomePage().getGameZoneButton().click();
        getPlayStationPage().waitVisibilityElement(10, getPlayStationPage().getPlayStationButton());
        getPlayStationPage().getPlayStationButton().click();
        getPlayStationPage().waitVisibilityElement(10, getPlayStationPage().getPlayStation5filter());
        getPlayStationPage().getPlayStation5filter().click();
        int products = getPlayStationPage().getProductList().size();
        assertEquals(products, 3);
    }

    @Test(priority = 3)
    public void checkLanguageChange() {
        String language1 = getHomePage().getTextToLanguageTest().getText();
        getHomePage().getLanguageButton().click();
        getHomePage().getChangeLanguageButton().click();
        String language2 = getHomePage().getTextToLanguageTest().getText();
        assertNotEquals(language1, language2);
    }

}
