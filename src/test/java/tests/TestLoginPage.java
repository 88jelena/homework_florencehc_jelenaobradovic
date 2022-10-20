package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import static objects.LoginPage.*;
import static resources.Constants.*;

public class TestLoginPage extends BaseTestClass {


    @Test
    public void verifyPageElements(){
        loginVerifyForm();
        Assert.assertTrue(getForgetInfo().isDisplayed());
        Assert.assertTrue(getRegisterLink().isDisplayed());
    }

    @Test
    public void loginVerifyForm(){
        wait.until(ExpectedConditions.visibilityOf(getUserNameField()));
        Assert.assertTrue(getUserNameField().isDisplayed());
        Assert.assertTrue(getPassField().isDisplayed());
        Assert.assertTrue(getLoginButton().isEnabled());
    }

    @Test (dependsOnMethods = {"loginVerifyForm"})
    public void loginValidUser(){
        logIn(user.getUsername(), user.getPass());
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains(LOGGED_IN_URL), "Unexpected url found: "+ currentURL);
        wait.until(ExpectedConditions.visibilityOf(getLogOutLink()));

    }


    @Test (priority = 1, dependsOnMethods = "loginVerifyForm")
    public void loginWithoutCredentials(){
        logIn("", "");
        wait.until(ExpectedConditions.visibilityOf(getLogInErrorMsg()));
        String expectedMsg = "Error!\n" +
                "Please enter a username and password.";
        Assert.assertEquals(getLogInErrorMsg().getText(), expectedMsg);
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains(LOGIN_URL), "Unexpected url found: "+ currentURL);

    }

    @Test (dependsOnMethods = "loginVerifyForm",
    enabled = false, description = "skipped - login is possible with any credentials ")
    public void loginUnregisteredUser(){
        logIn(user.getUsername(), user.getPass());
        wait.until(ExpectedConditions.visibilityOf(getLogInErrorMsg()));
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains(LOGIN_URL));

    }

    @Test (dependsOnMethods = "loginVerifyForm")
    public void loginMissingUsername(){
        logIn("", user.getPass());
        wait.until(ExpectedConditions.visibilityOf(getLogInErrorMsg()));
        String expectedMsg = "Error!\n" +
                "Please enter a username and password.";
        Assert.assertEquals(getLogInErrorMsg().getText(), expectedMsg);
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains(LOGIN_URL), "Unexpected url found: "+ currentURL);
    }

    @Test (dependsOnMethods = "loginVerifyForm")
    public void loginMissingPass(){
        logIn(user.getUsername(), "");
        wait.until(ExpectedConditions.visibilityOf(getLogInErrorMsg()));
        String expectedMsg = "Error!\n" +
                "Please enter a username and password.";
        Assert.assertEquals(getLogInErrorMsg().getText(), expectedMsg);
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains(LOGIN_URL), "Unexpected url found: "+ currentURL);
    }


    @Test(dependsOnMethods = {"loginValidUser", "loginVerifyForm"})
    public void logOutUser(){
        logOut();
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains(HOMEPAGE_URL), "Unexpected url found: "+ currentURL);
    }

    /* cases like boundary value testing, case sensitivity,
    field colour for required fieds are not forgotten,
    but do not have sense for this website
     */

}
