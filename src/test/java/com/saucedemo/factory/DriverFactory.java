package com.saucedemo.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    private WebDriver driver;

    public WebDriver initializeDriver() {
        String browser = System.getProperty("browser", "chrome"); // if the browser is not specified as input, GoogleChrome browser will operate as default
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "firfox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("error in entered browser type");

        }
        driver.manage().window().maximize();
        return driver;
    }//end method initializeDriver()
}//end class DriverFactory
