package com.saucedemo.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    public static WebElement findWebElement(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }
    public static boolean verifyElementVisible(WebDriver driver, By by) {
        try {
            WaitsUtils.explicitlyWaitForVisibility(driver, by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }//end verifyElementVisible() method

    //TODO: Send data to element after checking visibility
    public static void sendData(WebDriver driver, By locator, String data) {
        WaitsUtils.explicitlyWaitForVisibility(driver, locator);
        findWebElement(driver, locator).sendKeys(data);
    }

    //TODO: Click on element after checking clickability
    public static void click(WebDriver driver, By locator) {
        WaitsUtils.explicitlyWaitForClickability(driver, locator);
        findWebElement(driver, locator).click();
    }

    //TODO: get text from element after checking visibility
    public static String getText(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(ProductionConfigUtils.getConfigValue( "WAIT_DEFAULT"))))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return findWebElement(driver, locator).getText();

    }

}
