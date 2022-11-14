import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.security.Key;
import java.util.concurrent.TimeUnit;

public class XpathPractice {
    private WebDriver driver;
    private String baseurl;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        baseurl = "https://courses.letskodeit.com/practice";
        driver.get(baseurl);
    }

    @Test
    public void test1() throws InterruptedException {
        //Radio Button Example with xpath
        driver.findElement(By.xpath("//input[@id='bmwradio']")).click();
        //driver.findElement(By.id("bmwradio")).click();
        driver.findElement(By.xpath("//input[@value='honda']")).click();
        driver.findElement(By.xpath("//input[@value='benz']")).click();
        //Multiple Select Example with cssSelctor
        driver.findElement(By.cssSelector("option[value='apple']")).click();
        driver.findElement(By.cssSelector("option[value='peach']")).click();
        driver.findElement(By.cssSelector("option[value='orange']")).click();
//Select Class Example with
        driver.findElement(By.cssSelector("option[value='bmw']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//option[@value='honda']")).click();
        Thread.sleep(1000);
        //driver.findElement(By.xpath("//option[@value='benz']]")).click();
    }

    @Test
    public void checkbox() {
        driver.findElement(By.cssSelector("input#bmwcheck")).click();
        driver.findElement(By.xpath("//input[@id='benzcheck']")).click();
        driver.findElement(By.cssSelector("input#hondacheck")).click();
    }

    @Test
    public void switchWindow() {
        driver.findElement(By.xpath("//button[@id='openwindow']")).click();
    }

    @Test
    public void switchTab() {
        driver.findElement(By.cssSelector("a#opentab")).click();
    }

    @Test
    public void alertSwitch() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='enter-name']")).sendKeys("Dipu Thakor");
        //driver.findElement(By.cssSelector("#alertbtn")).click();
        driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        //alert.accept();
        alert.dismiss();
    }

    @Test
    public void iframeSwitch() {
        //driver.switchTo().frame(0); // switch to iframe by index
        // driver.switchTo().frame("courses-iframe"); //switch to iframe by id
        driver.switchTo().frame("iframe-name"); //switch to iframe by name
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
        searchBox.sendKeys("Java");
        searchBox.sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//iframe[@id='courses-iframe']")).click();
    }

    @Test
    public void disableEnable() {
        //select Disable button
        driver.findElement(By.id("disabled-button")).click();
        driver.findElement(By.cssSelector("#enabled-example-input")).click();
        System.out.println("Field is Disabled");
        //Select Enable button
        driver.findElement(By.id("enabled-button")).click();
        System.out.println("Field is Enabled");
        driver.findElement(By.cssSelector("#enabled-example-input")).sendKeys("Field is Enabled");
    }

    @Test
    public void hideShow() throws InterruptedException {
        driver.findElement(By.cssSelector("input#hide-textbox")).click();
        System.out.println("Display Box is hidden");
        Thread.sleep(3000);
        driver.findElement(By.id("show-textbox")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='displayed-text']")).sendKeys("Dipu Thakor");
    }

    @Test
    public void mouseHooverAction() throws InterruptedException {
        WebElement mainElement = driver.findElement(By.xpath("//button[@id='mousehover']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(mainElement).perform();
        WebElement topElement = driver.findElement(By.xpath("//a[@href='#top']"));
        actions.moveToElement(topElement).click().perform();
        Thread.sleep(2000);
        WebElement mainElement1 = driver.findElement(By.xpath("//button[@id='mousehover']"));
        actions.moveToElement(mainElement1).perform();
        Thread.sleep(2000);
        WebElement reloadElement = driver.findElement(By.xpath("//*[@id='mouse-hover-example-div']/div/fieldset/div/div/a[2]"));
        Thread.sleep(2000);
        actions.moveToElement(reloadElement).click().perform();
        Thread.sleep(2000);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}












