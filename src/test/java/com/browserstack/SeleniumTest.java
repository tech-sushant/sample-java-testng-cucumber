package com.browserstack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONObject;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SeleniumTest {
    protected static WebDriver driver;
    
    public void setUp() throws Exception {
        String browserName = System.getProperty("browser", "chrome");
        
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().clearDriverCache().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--disable-web-security");
                chromeOptions.addArguments("--allow-running-insecure-content");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser not supported: " + browserName);
        }
        
        driver.manage().window().maximize();
    }
    
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}
