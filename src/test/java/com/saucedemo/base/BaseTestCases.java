package com.saucedemo.base;

import com.saucedemo.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;

import static com.saucedemo.Utilities.Utils.takeScreenshot;

public class BaseTestCases {
    protected WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        driver = new DriverFactory().initializeDriver();
    }
    @AfterMethod
    public void trearDown(ITestResult result) {
        String TCname = result.getMethod().getMethodName();
        File destFile = new File ("targets"+File.separator+"screenshos"+ File.separator+TCname+".png");
        takeScreenshot(destFile,driver);
        driver.quit();
    }
}
