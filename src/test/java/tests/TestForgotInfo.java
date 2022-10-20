package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static objects.LoginPage.*;
import static resources.Constants.FORGOT_USER_URL;

public class TestForgotInfo extends BaseTestClass{


    @BeforeMethod
    public void forgetSetup(){
        wait.until(ExpectedConditions.visibilityOf(getForgetInfo()));
        getForgetInfo().click();
        wait.until(ExpectedConditions.visibilityOf(getForgetForm()));
    }

    @AfterMethod
    public void validateUrlAfterError(){
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains(FORGOT_USER_URL), "Unexpected url found: "+ currentURL);
    }

    @Test()
    public void forgetMyInfoNegativeUnexistingUser(){
        findLoginInfo(user.getFirstname(), user.getLastname(), user.getAddress(), user.getCity(),
                user.getState(), user.getZipcode(), user.getSsn());
        String expectedMsg = "Error!\n" +
                "The customer information provided could not be found.";
        Assert.assertEquals(getLogInErrorMsg().getText(), expectedMsg);

    }

    @Test()
    public void forgetMyInfoNameMissing(){
        findLoginInfo("", user.getLastname(), user.getAddress(), user.getCity(),
                user.getState(), user.getZipcode(), user.getSsn());
        Assert.assertTrue(getForgetFirstNameError().isDisplayed());
        Assert.assertEquals(getForgetFirstNameError().getText(), "First name is required.");


    }

    @Test()
    public void forgetMyInfoLastNameMissing(){
        findLoginInfo(user.getFirstname(), "", user.getAddress(), user.getCity(),
                user.getState(), user.getZipcode(), user.getSsn());
        Assert.assertTrue(getForgetLastNameError().isDisplayed());
        Assert.assertEquals(getForgetLastNameError().getText(), "Last name is required.");

    }

    @Test()
    public void forgetMyInfoAddressMissing(){
        findLoginInfo(user.getFirstname(), user.getLastname(), "", user.getCity(),
                user.getState(), user.getZipcode(), user.getSsn());
        Assert.assertTrue(getForgetAddressError().isDisplayed());
        Assert.assertEquals(getForgetAddressError().getText(), "Address is required.");

    }

    @Test()
    public void forgetMyInfoCityMissing(){
        findLoginInfo(user.getFirstname(), user.getLastname(), user.getAddress(), "",
                user.getState(), user.getZipcode(), user.getSsn());
        Assert.assertTrue(getForgetCityError().isDisplayed());
        Assert.assertEquals(getForgetCityError().getText(), "City is required.");

    }

    @Test()
    public void forgetMyInfoStateMissing(){
        findLoginInfo(user.getFirstname(), user.getLastname(), user.getAddress(), user.getCity(),
                "", user.getZipcode(), user.getSsn());
        Assert.assertTrue(getForgetStateError().isDisplayed());
        Assert.assertEquals(getForgetStateError().getText(), "State is required.");

    }

    @Test()
    public void forgetMyInfoZipMissing(){
        findLoginInfo(user.getFirstname(), user.getLastname(), user.getAddress(), user.getCity(),
                user.getState(), "", user.getSsn());
        Assert.assertTrue(getForgetZipcodeError().isDisplayed());
        Assert.assertEquals(getForgetZipcodeError().getText(), "Zip Code is required.");

    }

    @Test()
    public void forgetMyInfoSSNMissing(){
        findLoginInfo(user.getFirstname(), user.getLastname(), user.getAddress(), user.getCity(),
                user.getState(), user.getZipcode(), "");
        Assert.assertTrue(getForgetSSNError().isDisplayed());
        Assert.assertEquals(getForgetSSNError().getText(), "Social Security Number is required.");

    }

    @Test(enabled = false,
    description = "not forgotten scenario, but skip - no req what should happen; user is never found")
    public void forgetMyInfoPositive(){

    }

}
