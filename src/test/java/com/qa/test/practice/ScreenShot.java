package com.qa.test.practice;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.qa.test.base.Base_Opencart;
import org.testng.annotations.Test;


import java.nio.file.Paths;
import java.util.regex.Pattern;

public class ScreenShot extends Base_Opencart {

    @Test(groups = {"Practice_Snip"})
    public void getSnip() throws InterruptedException {
        hm.getHomePage_URL();
        Thread.sleep(2000);
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./Screenshots/" + hm.getHomePage_Title() + System.currentTimeMillis() + ".png")));
    }

    @Test(groups = {"Practice_Snip"})
    public void getSnip_FullScreen() throws InterruptedException {
        hm.getHomePage_URL();
        Thread.sleep(2000);
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./Screenshots/" + "FULL PAGE_" + hm.getHomePage_Title() + System.currentTimeMillis() + ".png")).setFullPage(true));
    }
    @Test
    public void dropDownUsingElement_Has()
    {
        page.locator(".widget-content input[id='comboBox']").click();
//        page.locator("div[id='dropdown']:has(div:has-text('Item 2'))").first().click();

        Locator dropdown = page.locator(
                "div[id='dropdown']",
                new Page.LocatorOptions()
                        .setHas(page.locator("div", new Page.LocatorOptions().setHasText(Pattern.compile("^Item 2$"))))
        );

        dropdown.click();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./Screenshots/" + "FULL PAGE_" + hm.getHomePage_Title() + System.currentTimeMillis() + ".png")).setFullPage(true));
    }
}