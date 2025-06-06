package com.qa.designPattern_POM;

import com.microsoft.playwright.Page;

public class RegisterationPage_OpenKart {

    private String fName = "//input[@id='input-firstname']";
    private String lName = "//input[@id='input-lastname']";
    private String telNo ="//input[@id='input-telephone']";
    private String checkbox_RegPage ="//input[@name='agree']";
    private String continue_Reg = "//input[@value='Continue']";
    private String frstName = "dummy";
    private String lastName = "user";
    private String phNo = "1234567890";
    private String regSuccessBtn = "//*[@id='content']/div/div/a";

    Page page;

    public RegisterationPage_OpenKart(Page page)
    {
        this.page = page;
    }
    public void enterRegDetails()
    {
        page.fill(fName,frstName);
        page.fill(lName,lastName);
        page.fill(telNo,phNo);
        page.click(checkbox_RegPage);
        page.click(continue_Reg);
        page.click(regSuccessBtn);
    }
}
