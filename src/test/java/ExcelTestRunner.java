import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.ReadExcelData;

public class ExcelTestRunner {
    public static void main(String[] args)  {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.instagram.com/");

       String username= ReadExcelData.getParticularData(3,0);
        driver.findElement(By.name("email")).sendKeys(username);

        String password= ReadExcelData.getParticularData(1,1);
        driver.findElement(By.name("pass")).sendKeys(password);


    }
}
