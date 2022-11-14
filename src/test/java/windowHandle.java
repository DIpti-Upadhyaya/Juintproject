import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class windowHandle {
    WebDriver driver;
    String baseURL;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        baseURL = "https://courses.letskodeit.com/practice";
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void windowHandles() throws InterruptedException {
        String parentWindowHandle = driver.getWindowHandle();
        System.out.println(parentWindowHandle);
        driver.findElement(By.id("openwindow")).click();
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles);

        for (String handle : handles) {
            System.out.println(handle);
            if (!handle.equals(parentWindowHandle)) {
                driver.switchTo().window(handle);
                Thread.sleep(2000);
                driver.findElement(By.xpath("//a[@class='dynamic-link']")).click();
                Thread.sleep(2000);
                driver.close();
                break;
            }
        }
        Thread.sleep(2000);
        driver.switchTo().window(parentWindowHandle);
        driver.findElement(By.id("name")).sendKeys("Dipu Thakor");
        Thread.sleep(2000);
    }

@After
        public void tearDown(){
    driver.quit();
        }

    }


