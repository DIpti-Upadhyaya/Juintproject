package basicActionsPractice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownNopcommerce {

    WebDriver driver;

    String baserUrl;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baserUrl = "https://courses.letskodeit.com/practice";
        driver.manage().window().maximize();
    }

    @Test
    public void myTest() throws InterruptedException {
        driver.get(baserUrl);
        WebElement element = driver.findElement(By.id("carselect"));
        Select select = new Select(element);
        select.selectByIndex(1);
        Thread.sleep(3000);

//        select.selectByValue("benz");
//        select.selectByVisibleText("BMW");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
