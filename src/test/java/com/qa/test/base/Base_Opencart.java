package com.qa.test.base;

import com.microsoft.playwright.Page;
import com.qa.designPattern_POM.LoginPage_OpenKart;
import com.qa.designPattern_POM.Openkart_HomePage;
import com.qa.designPattern_POM.RegisterationPage_OpenKart;
import com.qa.opencart.factory.PlaywrightFactory;
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


    @Parameters({"browser"})
    @BeforeTest
    public void setup(String browserName) throws IOException
    {
         pf=new PlaywrightFactory();
         prop = pf.readCofiguration();
         if(browserName!=null) {
             prop.setProperty("browser",browserName);
         }
         page = pf.init_Playwright(prop);
         hm = new Openkart_HomePage(page);
         lm= new LoginPage_OpenKart(page);
    }

    @AfterTest
    public void teardownSession()
    {
        page.context().browser().close();
    }

}
