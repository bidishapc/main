package com.pageobjectmanager;

import com.pageobjectmodel.AddressPage;
import com.pageobjectmodel.CheckoutPage;
import com.pageobjectmodel.LoginPage;
import com.pageobjectmodel.SearchProduct;
import utility.FileReaderManager;

public class PageObjectManager {
    private LoginPage loginPage;
    private FileReaderManager fileReader;
    private static PageObjectManager pageObjectManager;
    private SearchProduct searchProduct;
    private CheckoutPage checkout;
    private AddressPage addressPage;

    public AddressPage getAddressPage() {
        if(addressPage==null){
            addressPage=new AddressPage();
        }
        return addressPage;
    }

    public CheckoutPage getCheckout() {
        if(checkout==null){
            checkout=new CheckoutPage();
        }
        return checkout;
    }

    public SearchProduct getSearchProduct() {
        if(searchProduct==null){
            searchProduct=new SearchProduct();
            }
            return searchProduct;
    }



    public LoginPage getLoginPage() {
        if(loginPage==null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }



    public FileReaderManager getFileReader() {
        if(fileReader==null){
            fileReader=new FileReaderManager();
        }
        return fileReader;
    }

    public static PageObjectManager getPageObjectManager() {
        if(pageObjectManager==null){
            pageObjectManager=new PageObjectManager();
        }
        return pageObjectManager;
    }

}
