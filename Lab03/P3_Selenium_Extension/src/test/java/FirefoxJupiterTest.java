import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

@ExtendWith(SeleniumJupiter.class)
class FirefoxJupiterTest {

    //3a
    @Test
    void testWithOneFirefox(FirefoxDriver driver) {
        driver.get("https://bonigarcia.github.io/selenium-jupiter/");
        assertThat(driver.getTitle(),
                containsString("JUnit 5 extension for Selenium"));
    }

    //3a
    @Test
    void testWithTwoFirefoxs(FirefoxDriver driver1,
                             FirefoxDriver driver2) {
        driver1.get("http://www.seleniumhq.org/");
        driver2.get("http://junit.org/junit5/");
        assertThat(driver1.getTitle(), startsWith("Selenium"));
        assertThat(driver2.getTitle(), equalTo("JUnit 5"));
    }

    //3b
    @Test
    void testWithHeadlessBrowser(HtmlUnitDriver driver) {
        driver.get("https://www.ua.pt");
        assertThat(driver.getTitle(),
                containsString("Universidade de Aveiro"));
    }

    //3c
    @Test
    void testWithRecorder(FirefoxDriver driver) {
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
    }
}
