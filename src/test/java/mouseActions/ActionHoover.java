package mouseActions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ActionHoover {

    private WebDriver driver;
    private String baseUrl;
    JavascriptExecutor jse;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl = "https://courses.letskodeit.com/practice";
//        jse = (JavascriptExecutor)driver;
        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test()
    public void testMouseHoverActions() throws Exception {
        driver.get(baseUrl);
        Thread.sleep(2000);
        WebElement mainElement = driver.findElement(By.id("mousehover"));
        Actions actions= new Actions(driver);
        actions.moveToElement(mainElement).perform();
        Thread.sleep(2000);
        WebElement subElement = driver.findElement(By.xpath("//a[text()='Top']"));
        //subElement.click(); // when this does not work use underneath action
        actions.moveToElement(subElement).click().perform();

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }


}
