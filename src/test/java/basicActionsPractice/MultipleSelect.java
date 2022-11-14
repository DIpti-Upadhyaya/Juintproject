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

import java.util.List;

public class MultipleSelect {

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
        WebElement element = driver.findElement(By.id("multiple-select-example"));
        Select select = new Select(element);

        select.selectByIndex(0);
        Thread.sleep(3000);

        select.selectByIndex(1);
        Thread.sleep(3000);

        select.selectByVisibleText("Apple");
        Thread.sleep(3000);

        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        for (WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
