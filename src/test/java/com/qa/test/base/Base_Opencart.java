package com.qa.test.base;

import com.microsoft.playwright.Page;
import com.qa.designPattern_POM.LoginPage_OpenKart;
import com.qa.designPattern_POM.Openkart_HomePage;
import com.qa.designPattern_POM.RegisterationPage_OpenKart;
import com.qa.opencart.factory.PlaywrightFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.io.IOException;
import java.util.Properties;


public class Base_Opencart {

    PlaywrightFactory pf;
    protected Page page;
    protected Openkart_HomePage hm;
    protected LoginPage_OpenKart lm;
    protected RegisterationPage_OpenKart rp;
    protected Properties prop;

    @Parameters({"browser","customURL"})
    @BeforeTest
    public void setup(String browserName, @Optional String custom_URL) throws IOException
    {
         pf=new PlaywrightFactory();
         prop = pf.readCofiguration();
        if(custom_URL!=null)
        {
            prop.setProperty("url",custom_URL);
        }
         if(browserName!=null)
         {
             prop.setProperty("browser",browserName);
         }
         page = pf.init_Playwright(prop);
         hm = new Openkart_HomePage(page);
         lm= new LoginPage_OpenKart(page);
    }

    @AfterTest
    public void teardownSession(ITestContext result)
    {
        String getName = result.getName();
        if(prop.getProperty("Tracing").equals("true")) {
            pf.stopTracing(getName);
        }
        page.context().browser().close();
    }
}
