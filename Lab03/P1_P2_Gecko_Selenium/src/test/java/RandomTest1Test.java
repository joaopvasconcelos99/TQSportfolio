
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class RandomTest1Test {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;


    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "///home/joaovasconcelos/Documents/geckodriver");
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void randomTest1() {
        driver.get("https://blazedemo.com/");
        driver.manage().window().setSize(new Dimension(1131, 692));
        driver.findElement(By.name("fromPort")).click();
        driver.findElement(By.cssSelector(".form-inline:nth-child(1) > option:nth-child(1)")).click();
        driver.findElement(By.name("toPort")).click();
        {
            WebElement dropdown = driver.findElement(By.name("toPort"));
            dropdown.findElement(By.xpath("//option[. = 'Cairo']")).click();
        }
        driver.findElement(By.cssSelector(".form-inline:nth-child(4) > option:nth-child(7)")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.cssSelector("tr:nth-child(3) .btn")).click();
        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.id("inputName")).sendKeys("Joao");
        driver.findElement(By.id("address")).click();
        driver.findElement(By.id("address")).sendKeys("Aveiro");
        driver.findElement(By.id("city")).sendKeys("Viseu");
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).sendKeys("Aveiro");
        driver.findElement(By.id("state")).click();
        driver.findElement(By.id("state")).sendKeys("Aveiro");
        driver.findElement(By.id("zipCode")).click();
        driver.findElement(By.id("zipCode")).sendKeys("3500");
        driver.findElement(By.id("cardType")).click();
        {
            WebElement dropdown = driver.findElement(By.id("cardType"));
            dropdown.findElement(By.xpath("//option[. = 'American Express']")).click();
        }
        driver.findElement(By.cssSelector("option:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".control-group:nth-child(8) > .control-label")).click();
        driver.findElement(By.id("creditCardNumber")).click();
        driver.findElement(By.id("creditCardNumber")).sendKeys("24500000000");
        driver.findElement(By.cssSelector(".control-group:nth-child(9) > .controls")).click();
        driver.findElement(By.id("creditCardMonth")).click();
        driver.findElement(By.cssSelector(".control-group:nth-child(10) > .controls")).click();
        driver.findElement(By.id("creditCardYear")).click();
        driver.findElement(By.id("creditCardYear")).click();
        driver.findElement(By.id("creditCardYear")).click();
        driver.findElement(By.id("creditCardYear")).sendKeys("2021");
        driver.findElement(By.id("nameOnCard")).click();
        driver.findElement(By.id("nameOnCard")).sendKeys("joao");
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }
}
