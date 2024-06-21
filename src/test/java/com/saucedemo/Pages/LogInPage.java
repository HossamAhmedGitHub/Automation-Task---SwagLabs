package com.saucedemo.Pages;

import com.saucedemo.Utilities.ProductionConfigUtils;
import com.saucedemo.Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {

    private WebDriver driver;
    private final String WRONG_CREDITENTIAL_ERROR_MESSAGE = "Epic sadface: Username and password do not match any user in this service"; //actual error message when entering wrong credentials
    private final String EMPTY_CREDITENTIALS_ERROR_MESSAGE = "Epic sadface: Username is required"; //actual error message when leaving mail and password empty
    private final String EMPTY_PASSWORD_ERROR_MESSAGE = "Epic sadface: Password is required";
    private final String EMPTY_USERNAME_ERROR_MESSAGE = "Epic sadface: Username is required";
    public LogInPage(WebDriver driver){
        this.driver = driver;
    }

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.xpath("//*[@data-test='error']");
    public LogInPage openLoginPage(){
        driver.get(ProductionConfigUtils.getEnvironmentPropertyValue("loginPageURL"));
        return new LogInPage(driver);
    }
    public boolean isUserNameFieldVisible(){
        return Utils.verifyElementVisible(driver,usernameField);
    }
    public boolean isPasswordFieldVisible(){
        return Utils.verifyElementVisible(driver,passwordField);
    }
    public LogInPage fillUsernameField(){
        Utils.sendData(driver,usernameField,ProductionConfigUtils.getEnvironmentPropertyValue("username"));
        return new LogInPage(driver);
    }
    public LogInPage fillPasswordField(){
        Utils.sendData(driver,passwordField,ProductionConfigUtils.getEnvironmentPropertyValue("password"));
        return new LogInPage(driver);
    }
    public LogInPage clickOnLoginButton(){
        Utils.click(driver,loginButton);
        return new LogInPage(driver);
    }
    public boolean isErrorMessageVisible(){
        return Utils.verifyElementVisible(driver,errorMessage);
    }
    public String getErrorMessageText(){
        return Utils.getText(driver,errorMessage);
    }
    public LogInPage fillInvalidUsername(){
        Utils.sendData(driver,usernameField,ProductionConfigUtils.getEnvironmentPropertyValue("invalidUsername"));
        return new LogInPage(driver);
    }
    public LogInPage fillInvalidPassword(){
        Utils.sendData(driver,passwordField,ProductionConfigUtils.getEnvironmentPropertyValue("invalidPassword"));
        return new LogInPage(driver);
    }

    public String getWRONG_CREDITENTIAL_ERROR_MESSAGE() {
        return WRONG_CREDITENTIAL_ERROR_MESSAGE;
    }

    public String getEMPTY_CREDITENTIALS_ERROR_MESSAGE() {
        return EMPTY_CREDITENTIALS_ERROR_MESSAGE;
    }

    public String getEMPTY_PASSWORD_ERROR_MESSAGE() {
        return EMPTY_PASSWORD_ERROR_MESSAGE;
    }

    public String getEMPTY_USERNAME_ERROR_MESSAGE() {
        return EMPTY_USERNAME_ERROR_MESSAGE;
    }
}//end class LogInPage
