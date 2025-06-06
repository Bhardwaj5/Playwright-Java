package com.qa.test.openkart;

import com.qa.test.base.Base_Opencart;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends Base_Opencart{

    @Test
    public void homePageURL(){
        String homePage_link = hm.getHomePage_URL();
        Assert.assertEquals(homePage_link,prop.getProperty("url"));
        System.out.println(homePage_link);
    }

    @DataProvider
    public Object[][] dataSets()
    {
        return new Object[][]{
                {"macbook"},
                {"Iphone"},
                {"Samsung"}
        };
    }

    @Test(dataProvider = "dataSets")
    public void searchProduct(String productName)
    {
        String verifyProduct = hm.doSearch(productName);
        System.out.println(verifyProduct);
    }


}
