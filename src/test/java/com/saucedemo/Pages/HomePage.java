package com.saucedemo.Pages;

import com.saucedemo.Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    private By swagLabsLogo = By.cssSelector(".primary_header .header_label .app_logo ");
    public boolean isSwagLabsLogoVisible(){
        return Utils.verifyElementVisible(driver,swagLabsLogo);
    }
}
