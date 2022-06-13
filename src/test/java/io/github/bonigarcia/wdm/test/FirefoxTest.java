package io.github.bonigarcia.wdm.test;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxTest {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
    	WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new FirefoxDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() {
        
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get("https://www.udemy.com/join/login-popup/?locale=pt_BR&response_type=html&next=https%3A%2F%2Fwww.udemy.com%2Fpt%2F");
        
        By searchInput = By.id("email--1");
        wait.until(presenceOfElementLocated(searchInput));
        driver.findElement(searchInput).sendKeys("teste@gmail.com");
        
        By searchInput2 = By.id("id_password");
        wait.until(presenceOfElementLocated(searchInput2));
        driver.findElement(searchInput2).sendKeys("123456");
                
        
        By searchButton = By.id("submit-id-submit");
        wait.until(elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();

        wait.until(textToBePresentInElementLocated(By.tagName("body"),
                "security check"));
    }

}