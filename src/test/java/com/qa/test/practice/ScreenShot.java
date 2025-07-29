package com.qa.test.practice;

import com.microsoft.playwright.Page;
import com.qa.test.base.Base_Opencart;
import org.testng.annotations.Test;


import java.nio.file.Paths;

public class ScreenShot extends Base_Opencart
{

    @Test
    public void getSnip() throws InterruptedException {
        hm.getHomePage_URL();
        Thread.sleep(2000);
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./Screenshots/"+hm.getHomePage_Title()+System.currentTimeMillis()+".png")));
    }

    @Test
    public void getSnip_FullScreen() throws InterruptedException {
        hm.getHomePage_URL();
        Thread.sleep(2000);
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./Screenshots/"+"FULL PAGE_"+hm.getHomePage_Title()+System.currentTimeMillis()+".png")).setFullPage(true));
    }
}
