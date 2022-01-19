import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Test
    public void checkEmptyBasketAlert() {
        getHomePage().getCartButton().click();
        String empty = getHomePage().getEmptyCartText().getText();
        getHomePage().getAcceptOrderButton().click();
        String titleEmpty = getHomePage().getCartTitleText().getText();
        assertEquals(empty, titleEmpty);
    }

}
