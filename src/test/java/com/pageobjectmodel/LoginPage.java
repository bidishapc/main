package com.pageobjectmodel;

import com.base.BaseClass;
import com.interfaceelements.LoginInterfaceElements;
import com.pageobjectmanager.PageObjectManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass implements LoginInterfaceElements {
    @FindBy(linkText =login_linkText )
    private static WebElement login;

    @FindBy(id=username_id)
    private static WebElement username;

    @FindBy(css=password_css)
    private static WebElement password;

    @FindBy(xpath=signin_xpath)
    private static WebElement signin;

    @FindBy(id=title_id)
    private static WebElement title;


    public LoginPage() {
        PageFactory.initElements(driver,this);
    }

    public static void validLogin() throws InterruptedException {
        clickOnElement(login);
        Thread.sleep(2000);
        passInput(username, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("username"));
        passInput(password,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("password"));
   clickOnElement(signin);
   Thread.sleep(2000);
   getText(title);
    }
}
