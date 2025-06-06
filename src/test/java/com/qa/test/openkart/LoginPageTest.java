package com.qa.test.openkart;
import com.qa.test.base.Base_Opencart;
import org.testng.annotations.Test;

public class LoginPageTest extends Base_Opencart {

    @Test(priority = -1)
    public void loginPageNavigation() {

        lm = hm.navigateTo_loginPage_Openkart();
    }

    @Test
    public void enterLoginCredentials()
    {
        lm.openLoginPage();
    }
}
