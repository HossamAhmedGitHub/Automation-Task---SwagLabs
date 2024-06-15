package com.saucedemo.TestCases;

import com.saucedemo.Pages.HomePage;
import com.saucedemo.Pages.LogInPage;
import com.saucedemo.base.BaseTestCases;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuite extends BaseTestCases {
    @Test(description = "Check if the username and password fields are on the main screen of the application")
    public void TC_01(){
        new LogInPage(driver).openLoginPage();
        Assert.assertTrue(new LogInPage(driver).isUserNameFieldVisible()); // assert the Username Field is visible in the main page
        Assert.assertTrue(new LogInPage(driver).isPasswordFieldVisible()); // assert the Password Field is visible in the main page
    }
    @Test(description = "Check if the given valid credentials work, Username: standard_user ,Password: secret_sauce")
    public void TC_02(){
        new LogInPage(driver)
                        .openLoginPage()
                        .fillUsernameField()
                        .fillPasswordField()
                        .clickOnLoginButton();
        Assert.assertTrue(new HomePage(driver).isSwagLabsLogoVisible()); //assert the Home logo is visible
    }

    @Test(description = "Check if the given wrong credentials work, Username: Hossam ,Password: sau1234 ")
    public void TC_03() throws InterruptedException {
        new LogInPage(driver)
                        .openLoginPage()
                        .fillInvalidUsername()
                        .fillInvalidPassword()
                        .clickOnLoginButton();
        Assert.assertTrue(new LogInPage(driver).isErrorMessageVisible()); // assert the error message appears
        Assert.assertEquals(new LogInPage(driver).getErrorMessageText(), new LogInPage(driver).getWRONG_CREDITENTIAL_ERROR_MESSAGE() );
    }
    @Test(description = "Check for empty credentials, when username is empty ")
    public void TC_04(){
        new LogInPage(driver)
                        .openLoginPage()
                        .fillPasswordField()
                        .clickOnLoginButton();
        Assert.assertTrue(new LogInPage(driver).isErrorMessageVisible());
        Assert.assertEquals(new LogInPage(driver).getErrorMessageText(), new LogInPage(driver).getEMPTY_USERNAME_ERROR_MESSAGE() );
    }

    @Test(description = "Check for empty credentials, when username is empty ")
    public void TC_05(){
        new LogInPage(driver)
                .openLoginPage()
                .fillUsernameField()
                .clickOnLoginButton();
        Assert.assertTrue(new LogInPage(driver).isErrorMessageVisible());
        Assert.assertEquals(new LogInPage(driver).getErrorMessageText(), new LogInPage(driver).getEMPTY_PASSWORD_ERROR_MESSAGE() );
    }


}//end class LoginTestCases
