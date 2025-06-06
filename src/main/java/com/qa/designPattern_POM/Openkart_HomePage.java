package com.qa.designPattern_POM;

import com.microsoft.playwright.Page;

public class Openkart_HomePage {
    private String searchBox= "input[name='search']";
    private String searchButton= "div[id='search'] span button[type='button']";
    private String searchPageHeader= "div#content h1";

    private String AccountButton="//span[normalize-space()='My Account']";
    private String loginButton="//a[text()='Login']";

    Page page;

    public Openkart_HomePage(Page page)
    {
        this.page= page;
    }
    public String getHomePage_Title()
    {
        return page.title();
    }
    public String getHomePage_URL()
    {
       return page.url();
    }

    public String doSearch(String productName)
    {
        page.fill(searchBox,productName);
        page.click(searchButton);
        String productName_header =  page.textContent(searchPageHeader);
        return productName_header;
    }

    public LoginPage_OpenKart navigateTo_loginPage_Openkart()
    {
        page.click(AccountButton);
        page.click(loginButton);
        return new LoginPage_OpenKart(page);
    }
}
