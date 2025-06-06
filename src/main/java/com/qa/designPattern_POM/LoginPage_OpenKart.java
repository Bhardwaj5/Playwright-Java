package com.qa.designPattern_POM;

import com.microsoft.playwright.Page;

public class LoginPage_OpenKart {

    private String userID="//input[@id='input-email']";
    private String password="//input[@id='input-password']";
    private String logButton = "//input[@value='Login']";
    private String incorrectCredentials = "//div[@class='alert alert-danger alert-dismissible']";
    private String continueBtn = "//a[normalize-space()='Continue']";
    private String logoutBtn = "//a[@class='list-group-item'][normalize-space()='Logout']";


    //Reg Page
    private String confirmPasword = "//input[@id='input-confirm']";

    private String id = "abcgdddgxyy@gmail.com";
    private String passwrd = "Qwertyui";
    Page page;

    public LoginPage_OpenKart(Page page)
    {
        this.page = page;
    }

    public void openLoginPage()
    {
        page.fill(userID,id);
        page.fill(password, passwrd);
        page.click(logButton);
    }

    public void goToNextPage()
    {
        page.click(continueBtn);
    }

    public RegisterationPage_OpenKart review_LoginCredentials()
    {
        if(page.isVisible(incorrectCredentials))
        {
            goToNextPage();
            page.fill(userID,id);
            page.fill(password, passwrd);
            page.fill(confirmPasword, passwrd);
            return new RegisterationPage_OpenKart(page);
        }
        else
        {
            System.out.println("User Logged In");
            return null;
        }
    }

    public boolean checkLoginStatus()
    {
        if(page.isVisible(logoutBtn)==true)
        {
            return true;
        }
        return false;

    }

}
