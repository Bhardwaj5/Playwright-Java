package com.qa.test.openkart;

import com.qa.test.base.Base_Opencart;
import org.testng.annotations.Test;

public class RegPageTest extends Base_Opencart {

    @Test
    public void enterLoginCredentials() throws InterruptedException {
        lm = hm.navigateTo_loginPage_Openkart();
        lm.openLoginPage();
        Thread.sleep(2500);

    }
    @Test(dependsOnMethods = {"enterLoginCredentials"})
    public void navigate_VerifyToRegPage() throws InterruptedException {

        if (lm.checkLoginStatus() == false)
        {
            rp = lm.review_LoginCredentials();
            Thread.sleep(2500);
            rp.enterRegDetails();
        }
        else
        {
            System.out.println("User Logged In Successfully. ");
        }
    }

}
