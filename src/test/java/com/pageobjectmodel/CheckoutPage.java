package com.pageobjectmodel;

import com.base.BaseClass;
import com.interfaceelements.CheckoutInterfaceElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutPage extends BaseClass implements CheckoutInterfaceElement {

    @FindBy(xpath = placeorder_xpath)
    private static WebElement place_order;

    public CheckoutPage() {
        PageFactory.initElements(driver,this);
    }
    public static void checkoutPage(){
clickOnElement(place_order);
    }
}
