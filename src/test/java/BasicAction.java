import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BasicAction {
    private WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void clickAndSendkeys() throws InterruptedException {
        String baseURL = "https://demo.nopcommerce.com/";
        driver.get(baseURL);
        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Dipu");
        driver.findElement(By.id("LastName")).sendKeys("Thakor");
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("5");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]")).sendKeys("April");
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("1999");
        driver.findElement(By.id("Email")).sendKeys("diptid"+Math.random()+"@yahoo.co.uk");
        driver.findElement(By.name("Company")).sendKeys("ABC Co");
        driver.findElement(By.id("Newsletter")).click();
        driver.findElement(By.name("Password")).sendKeys("ABC123");
        driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).sendKeys("ABC123");
        driver.findElement(By.id("register-button")).click();
        driver.findElement(By.className("ico-logout")).click();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
