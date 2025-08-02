package com.qa.opencart.factory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browse;
    BrowserContext browseCon;
    Page page;
    Properties prop;

    private static ThreadLocal<Playwright> tl_Playwright = new ThreadLocal<>();
    private static ThreadLocal<Browser> tl_Browser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> tl_BrowserContext = new ThreadLocal<>();
    private static ThreadLocal<Page> tl_Page = new ThreadLocal<>();

    public static Playwright getPlaywright()
    {
        return tl_Playwright.get();
    }

    public static Browser getBrowser()
    {
        return tl_Browser.get();
    }

    public static BrowserContext getBrowserContext()
    {
        return tl_BrowserContext.get();
    }

    public static Page getPage()
    {
        return tl_Page.get();
    }

    public Page init_Playwright(Properties prop) throws IOException {

        String headless_Value = prop.getProperty("headless_Value");
        String broswerApp = prop.getProperty("browser");
        String url = prop.getProperty("url");

        tl_Playwright.set(Playwright.create());
//        playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setHeadless(Boolean.parseBoolean(headless_Value));

        switch(broswerApp.toLowerCase())
        {
            case "chromium":
//                playwright.chromium().launch(lp);
                tl_Browser.set(tl_Playwright.get().chromium().launch(lp));
                break;

            case "chrome":
                tl_Browser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
                break;

            case "edge":
                tl_Browser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false)));
                break;

            case "firefox":
                lp.setChannel(broswerApp);
                browse = playwright.firefox().launch(lp);
                break;

            case "safari":
                lp.setChannel(broswerApp);
                browse = playwright.webkit().launch(lp);
                break;

            default:
                System.out.println("Please select mentioned browser");
        }
        tl_BrowserContext.set(getBrowser().newContext());
        if(prop.getProperty("Tracing").equals("true"))
        {
            getBrowserContext().tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));

        }
        tl_Page.set(getBrowserContext().newPage());
        getPage().navigate(url);
        return getPage();
    }

    public Properties readCofiguration() throws IOException {
        FileInputStream fis = new FileInputStream("./src/main/resources/Config/config.properties");
        prop = new Properties();
        prop.load(fis);
        return prop;
    }

    public void stopTracing(String getTestName)
    {
        getBrowserContext().tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("./TraceFolder/Trace_"+getTestName+".zip")));
    }
}
