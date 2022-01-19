package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertNotNull;

public class LoginFormTest extends BaseTest{
    private static String invalidEmailText = "123321";

    @Test
    public void checkErrorMessageLogin(){
        getHomePage().clickUserButton();
        getHomePage().implicitlyWait(10);
        getHomePage().fillEmailField(invalidEmailText);
        getHomePage().waitVisibilityOfElement(10, getHomePage().getErrorMessage());
        assertNotNull(getHomePage().getErrorMessage());
    }
}
