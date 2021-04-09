package com.toptal.tests;

// Generated by Selenium IDE
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

public class UntitledTest {

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
  public void untitled() {
    driver.get("https://www.toptal.com/");
    driver.manage().window().setSize(new Dimension(1131, 694));
    driver.findElement(By.linkText("Apply as a Freelancer")).click();
    driver.findElement(By.id("talent_create_applicant_full_name")).click();
    driver.findElement(By.id("talent_create_applicant_full_name")).sendKeys("joao");
    driver.findElement(By.id("talent_create_applicant_email")).click();
    driver.findElement(By.id("talent_create_applicant_email")).sendKeys("joao@ua.pt");
    driver.findElement(By.id("talent_create_applicant_password")).click();
    driver.findElement(By.id("talent_create_applicant_password")).sendKeys("1234");
    driver.findElement(By.id("talent_create_applicant_password_confirmation")).click();
    driver.findElement(By.id("talent_create_applicant_password_confirmation")).sendKeys("1234");
    driver.findElement(By.id("save_new_talent_create_applicant")).click();
  }
}