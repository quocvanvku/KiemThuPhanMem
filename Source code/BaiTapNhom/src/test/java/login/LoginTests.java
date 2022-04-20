package login;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.SecureArePage;

public class LoginTests extends BaseTests {

    @Test
    @DisplayName("TC01-Login successfully")
    public void testLoginSuccessful() {
        LoginPage loginPage = homePage.clickForm();
        loginPage.setUserName("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureArePage secureArePage = loginPage.clickLoginButton();
        String alertText = secureArePage.getAlertText();
        //Assertions.assertTrue(alertText.contains("Yoy logged into a secure area!"), "Alert text is incorrect!");
    }

}
