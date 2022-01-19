package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    private static String searchText = "Susvara";

    @Test
    public void addToCartCheck() {
        getHomePage().fillSearchField(searchText);
        getProductPage().waitVisibilityOfElement(10, getProductPage().getBuyButton());
        getProductPage().implicitlyWait(10);
        getProductPage().clickBuyButton();
        getProductPage().implicitlyWait(30);
        getProductPage().waitVisibilityOfElement(10,getProductPage().getCloseCartButton());
        getProductPage().clickCloseCartButton();
        String expectedResult = "1";
        Assert.assertEquals(getProductPage().getTextOfCounter(), expectedResult);
    }

}
