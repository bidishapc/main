package com.pageobjectmodel;

import com.base.BaseClass;
import com.interfaceelements.AddressInterfaceElements;
import com.pageobjectmanager.PageObjectManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends BaseClass implements AddressInterfaceElements {

    @FindBy(id=name_id)
    private static WebElement name;

    @FindBy(id=country_id)
    private static WebElement country;

    @FindBy(xpath=city_xpath)
    private static WebElement city;

    @FindBy(id=credit_id)
    private static WebElement credit;

    @FindBy(id=month_id)
    private static WebElement month;

    @FindBy(id=year_id)
    private static WebElement year;

    @FindBy(xpath=purchase_xpath)
    private static WebElement purchase;

    public static void addressPage() throws InterruptedException {
        passInput(name, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("name"));
        Thread.sleep(2000);
        passInput(country, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("country"));
        passInput(city, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("city"));
        passInput(credit, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("credit"));
        passInput(month, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("month"));
        passInput(year, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("year"));
Thread.sleep(3000);
   clickOnElement(purchase);
    }


    public AddressPage() {
        PageFactory.initElements(driver,this);
    }

}
