package com.pageobjectmodel;

import com.base.BaseClass;
import com.interfaceelements.SearchProductInterfaceElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchProduct extends BaseClass implements SearchProductInterfaceElements {
    @FindBy(linkText=laptop_linkText)
    private static WebElement laptop;

    @FindBy(linkText = sony_linkText)
    private static WebElement sony;

    @FindBy(xpath= addcart_xpath)
    private static WebElement cart;

    @FindBy(linkText = cart_linkText)
    private static WebElement maincart;

    public SearchProduct() {

        PageFactory.initElements(driver,this);
    }


    public static void searchProduct() throws InterruptedException {
        clickOnElement(laptop);
       clickOnElement(sony);
       Thread.sleep(2000);
       clickOnElement(cart);
       Thread.sleep(5000);
        simpleConfirAlert("accept");
       clickOnElement(maincart);


    }

}
