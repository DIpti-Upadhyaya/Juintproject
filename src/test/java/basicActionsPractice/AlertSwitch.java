package basicActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertSwitch {

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
        driver.findElement(By.id("name")).sendKeys("Nirav");
//        driver.findElement(By.id("alertbtn")).click();
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();
//       alert.accept();
        alert.dismiss();
        Thread.sleep(3000);

    }

    @After
    public void tearDown(){
        driver.quit();
    }

}

