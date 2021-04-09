import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SampleTest {

    WebDriver browser;

    @BeforeEach
    void SetUp(){
        System.setProperty("webdriver.gecko.driver", "///home/joaovasconcelos/Documents/geckodriver");
        FirefoxOptions options = new FirefoxOptions().addPreference("browser.startup.homepage", "https://www.saucelabs.com");
        browser = new FirefoxDriver(options);
    }

    @Test
    void site_header_is_on_home_page(){
        browser.get("https://www.saucelabs.com");
        WebElement href = browser.findElement(By.xpath("//a[@href='https://accounts.saucelabs.com/']"));
        assertTrue((href.isDisplayed()));
    }

    @AfterEach
    void tearDown() {browser.close();}
}
