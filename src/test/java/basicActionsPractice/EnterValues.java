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

public class EnterValues {

    WebDriver driver;

    String baserUrl;
    String username = "niravgoyani007";

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        baserUrl = "https://courses.letskodeit.com/practice";

        driver.get(baserUrl);
    }

    @Test
    public void myTest() throws InterruptedException {
        driver.findElement(By.id("name")).sendKeys(username);
//        driver.findElement(By.className("inputs")).sendKeys("niravgoyani007@gmail.com");
        Thread.sleep(3000);

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}