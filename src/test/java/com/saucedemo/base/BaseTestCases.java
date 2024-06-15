package com.saucedemo.base;

import com.saucedemo.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestCases {
    protected WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        driver = new DriverFactory().initializeDriver();
    }
    @AfterMethod
    public void trearDown(ITestResult result) {
        driver.quit();
    }
}
