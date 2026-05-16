import com.base.BaseClass;
import com.pageobjectmanager.PageObjectManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestRunner extends BaseClass {
    public static void main(String[] args) throws InterruptedException {
        launchBrowser(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("browser"));
        launchUrl(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("url"));
        PageObjectManager.getPageObjectManager().getLoginPage().validLogin();
        screenshot(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("screenshot"));
        PageObjectManager.getPageObjectManager().getSearchProduct().searchProduct();
        PageObjectManager.getPageObjectManager().getCheckout().checkoutPage();
        PageObjectManager.getPageObjectManager().getAddressPage().addressPage();
        screenshot(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("screenshot"));
    }
}
