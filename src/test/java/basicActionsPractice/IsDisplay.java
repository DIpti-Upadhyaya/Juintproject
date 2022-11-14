package basicActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class IsDisplay {

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
        driver.findElement(By.id("hide-textbox")).click();

        System.out.println(driver.findElement(By.id("displayed-text")).isDisplayed());
        Thread.sleep(2000);

        driver.findElement(By.id("show-textbox")).click();

        if(driver.findElement(By.id("displayed-text")).isDisplayed()){

            driver.findElement(By.id("displayed-text")).clear();
            driver.findElement(By.id("displayed-text")).sendKeys("Nirav is done for day");

        }
        Thread.sleep(3000);

    }

    @After
    public void tearDown(){
        driver.quit();
    }



}
