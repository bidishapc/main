package com.base;


import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.FileReaderManager;


import java.awt.*;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public abstract class BaseClass {
    public static WebDriver driver;

    protected static WebDriver launchBrowser(String browserName){
       try{

       if(browserName.equalsIgnoreCase("chrome")) {
           driver = new ChromeDriver();
       }else if(browserName.equalsIgnoreCase("firefox")) {
           driver = new FirefoxDriver();
       }else if(browserName.equalsIgnoreCase("safari")) {
           driver = new SafariDriver();
       }

           }catch(Exception e) {
           Assert.fail("ERROR : DURING BROWSER LAUNCH");
       }
       driver.manage().window().maximize();
       return driver;
       }

     protected static void launchUrl(String url){
        try {
            driver.get(url);
        }catch(Exception e) {
            Assert.fail("ERROR :  LAUNCHURL ERROR");
        }
        }

 protected static void clickOnElement(WebElement element)  {
        try{
            element.click();
        }catch(Exception e){
            Assert.fail("ERROR : CLICKONELEMENT ERROR");
        }
 }
 protected static void getText(WebElement element){
        try
        {
            String text = element.getText();
            System.out.println(text);
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING GETING TEXT");
        }
 }
 protected static void passInput(WebElement element, String value){
        try{
            element.sendKeys(value);
        }catch(Exception e){
            Assert.fail("ERROR : SENDKEYS ERROR");
        }
 }
 protected static void navigateTo(String url){
        try {
            driver.navigate().to(url);
        } catch (Exception e) {
            Assert.fail("ERROR : NAVIGATION ERROR");
        }
    }

    protected static void backUrl(){
        try {
            driver.navigate().back();
        } catch (Exception e) {
            Assert.fail("ERROR : NAVIATEBACK ERROR");
        }
    }
    protected static void forwardUrl(){
        try {
            driver.navigate().forward();
        } catch (Exception e) {
            Assert.fail("ERROR : NAVIGATEFORWARD ERROR");
        }
    }
    protected static void refresh(){
        try {
            driver.navigate().refresh();
        } catch (Exception e) {
            Assert.fail("ERROR : REFRESH ERROR");
        }
    }

protected static void selectOptions(WebElement element,String type,String value){
    Select sel=new Select(element);
   try{
       if(type.equalsIgnoreCase("TEXT")) {
           sel.selectByVisibleText(value);
       }else if(type.equalsIgnoreCase("INDEX")) {
           sel.selectByIndex(Integer.parseInt(value));
       }else if(type.equalsIgnoreCase("VALUE")){
           sel.selectByValue(value);
       }

        }catch(Exception e) {
       Assert.fail("ERROR : DROPDOWN ERROR");
        }
        }

protected static void deSelectOptions(WebElement element,String type,String value){
    Select sel1=new Select(element);
        try{
            if(type.equalsIgnoreCase("TEXT")) {
                sel1.deselectByVisibleText(value);
            }else if(type.equalsIgnoreCase("INDEX")) {
                sel1.deselectByIndex(Integer.parseInt(value));
            }else if(type.equalsIgnoreCase("VALUE")){
                sel1.deselectByValue(value);
            }

        }catch(Exception e){
            Assert.fail("ERROR : DESELECT ERROR");
        }
}


protected static void windowHandling(int number){
            try {
                List<String> allWindows = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(allWindows.get(number));
            } catch (Exception e) {
                Assert.fail("ERROR OCCUR DURING WINDOW HANDLES");
            }

    }
protected static void browserTermination(){
        try{
            driver.quit();
        }catch(Exception e){
            Assert.fail("ERROR : BROWSER TERMINATION ERROR");
        }
    }
    protected static void screenshot(String location){
        try{
            Date currentDate=new Date();
            System.out.println(currentDate);
            String dateFile=currentDate.toString().replace(" ","_").replace(":","_");
            System.out.println(dateFile);

            String location1 =".//Screenshot/";

            File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot,new File(location1 +dateFile +".png"));
        } catch (Exception e) {
            Assert.fail("ERROR IN SCREENSHOT");
        }
    }
    protected static void simpleConfirAlert(String action) {
        try {
            Alert alert = driver.switchTo().alert();
            //WebDriverWait wait=new WebDriverWait(driver, Duration.OfSeconds(10));
            if(action.equalsIgnoreCase("accept")){
                System.out.println(alert.getText());
                alert.accept();

            }else if(action.equalsIgnoreCase("dismiss"))
            {
                alert.dismiss();
            }

        } catch (Exception e) {
            Assert.fail("ERROR : SIMPLE OR CONFIRMATION ALERT ERROR");
        }

    }
    protected static void PromtAlert(String action,String value){
        try{
            Alert alert1 = driver.switchTo().alert();
            alert1.sendKeys(value);

            if (action.equalsIgnoreCase("accept")) {
                alert1.accept();
            }
            else if(action.equalsIgnoreCase("dismiss"))
            {
                alert1.dismiss();
            }
        }catch(Exception e){
            Assert.fail("ERROR:ERROR IN PROMT ALERT");
        }
    }

/////////////////////////////////////////////////////
    //protected static void keyBoardEvent() throws AWTException {
    //   Robot robo=new Robot();


protected static void actions(WebElement element) {
    Actions act = new Actions(driver);
    try {

    } catch (Exception e) {

    }
}

    protected static void frames(WebElement element) {
        driver.switchTo().frame(element);
        try {
            element.sendKeys();

        } catch (Exception e) {
            Assert.fail("ERROR : ERROR IN FRAMES");
        }
    }
}