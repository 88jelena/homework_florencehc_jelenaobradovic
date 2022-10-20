package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static objects.LoginPage.*;
import static objects.RegisterPage.*;
import static resources.Constants.REGISTER_URL;

public class TestRegisterPage extends BaseTestClass {

    @BeforeMethod
    public void registerSetup(){
        wait.until(ExpectedConditions.visibilityOf(getRegisterLink()));
        getRegisterLink().click();
        wait.until(ExpectedConditions.visibilityOf(getRegisterForm()));
    }

    public void validateUrlAfterError(){
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        Assert.assertEquals(currentURL, REGISTER_URL, "Unexpected url found: "+ currentURL);
    }

    @Test()
    public void registerNewUser(){
        // register user has a bug, saying username exists even when is completely random and new
        registerUser(user.getFirstname(), user.getLastname(), user.getAddress(), user.getCity(),
                user.getState(), user.getZipcode(), user.getPhone(), user.getSsn(),
                user.getUsername(), user.getPass(), user.getPass());
        wait.until(ExpectedConditions.visibilityOf(getLogOutLink()));
        String expectedMsg = "Welcome " + user.getUsername() + "\n" +
                "Your account was created successfully. You are now logged in.";
        String actualMsg = getLogInErrorMsg().getText();
        Assert.assertEquals(actualMsg, expectedMsg, "unnexpected msg"+actualMsg);

    }

    @Test(dependsOnMethods = "registerNewUser")
    public void registerExistingUser(){
        logOut();
        wait.until(ExpectedConditions.visibilityOf(getRegisterLink()));
        getRegisterLink().click();
        wait.until(ExpectedConditions.visibilityOf(getRegisterForm()));
        registerUser(user.getFirstname(), user.getLastname(), user.getAddress(), user.getCity(),
                user.getState(), user.getZipcode(), user.getPhone(), user.getSsn(),
                user.getUsername(), user.getPass(), user.getPass());
        Assert.assertTrue(getRegisterUserNameFieldError().isDisplayed());
        Assert.assertEquals(getRegisterUserNameFieldError().getText(), "This username already exists.");

    }

    @Test()
    public void registerUserNoData(){
        registerUser("", "", "", "", "", "", "", "", "", "", "");
        wait.until(ExpectedConditions.visibilityOf(getRegisterNameFieldError()));
        Assert.assertTrue(getRegisterNameFieldError().isDisplayed());
        Assert.assertEquals(getRegisterNameFieldError().getText(), "First name is required.");

        Assert.assertTrue(getRegisterLastNameFieldError().isDisplayed());
        Assert.assertEquals(getRegisterLastNameFieldError().getText(), "Last name is required.");

        Assert.assertTrue(getRegisterAddressFieldError().isDisplayed());
        Assert.assertEquals(getRegisterAddressFieldError().getText(), "Address is required.");

        Assert.assertTrue(getRegisterCityFieldError().isDisplayed());
        Assert.assertEquals(getRegisterCityFieldError().getText(), "City is required.");

        Assert.assertTrue(getRegisterStateFieldError().isDisplayed());
        Assert.assertEquals(getRegisterStateFieldError().getText(), "State is required.");

        Assert.assertTrue(getRegisterZipFieldError().isDisplayed());
        Assert.assertEquals(getRegisterZipFieldError().getText(), "Zip Code is required.");

        Assert.assertTrue(getRegisterSSNFieldError().isDisplayed());
        Assert.assertEquals(getRegisterSSNFieldError().getText(), "Social Security Number is required.");

        Assert.assertTrue(getRegisterUserNameFieldError().isDisplayed());
        Assert.assertEquals(getRegisterUserNameFieldError().getText(), "Username is required.");

        Assert.assertTrue(getRegisterPassFieldError().isDisplayed());
        Assert.assertEquals(getRegisterPassFieldError().getText(), "Password is required.");

        Assert.assertTrue(getRegisterConfirmFieldError().isDisplayed());
        Assert.assertEquals(getRegisterConfirmFieldError().getText(), "Password confirmation is required.");
        validateUrlAfterError();
        Assert.assertTrue(getRegisterForm().isDisplayed());

    }

    @Test()
    public void registerVerifyPhoneNotReqField(){
        registerUser(user.getFirstname(), user.getLastname(), user.getAddress(), user.getCity(),
                user.getState(), user.getZipcode(), "", user.getSsn(),
                user.getUsername(), user.getPass(), user.getPass());
        wait.until(ExpectedConditions.visibilityOf(getLogOutLink()));
        String expectedMsg = "Welcome " + user.getUsername() + "\n" +
                "Your account was created successfully. You are now logged in.";
        String actualMsg = getLogInErrorMsg().getText();
        Assert.assertEquals(actualMsg, expectedMsg, "unnexpected msg"+actualMsg);

    }

    @Test()
    public void registerInvalidPassConfirm(){
        registerUser(user.getFirstname(), user.getLastname(), user.getAddress(), user.getCity(),
                user.getState(), user.getZipcode(), "", user.getSsn(),
                user.getUsername(), user.getPass(), user.getFirstname());
        wait.until(ExpectedConditions.visibilityOf(getRegisterConfirmFieldError()));
        String expectedMsg = "Passwords did not match.";
        String actualMsg = getRegisterConfirmFieldError().getText();
        Assert.assertEquals(actualMsg, expectedMsg, "unnexpected msg"+actualMsg);
        Assert.assertTrue(getRegisterForm().isDisplayed());
        validateUrlAfterError();

    }

}
