package basicActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAction {

    WebDriver driver;

    String baserUrl;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baserUrl = "https://courses.letskodeit.com/practice";
        driver.manage().window().maximize();
        driver.get(baserUrl);
    }

    @Test
    public void myTest() throws InterruptedException {

        driver.findElement(By.id("bmwcheck")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.id("bmwcheck")).isSelected());
        Thread.sleep(2000);

        System.out.println(driver.findElement(By.id("benzcheck")).isSelected());

        Thread.sleep(3000);

    }

    @After
    public void tearDown(){
        driver.quit();
    }

}

