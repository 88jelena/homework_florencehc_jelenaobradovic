package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static resources.Constants.*;

public class LoginPage extends BaseClass {

    public static WebElement getUserNameField(){
        return driver.findElement(By.name(LOGIN_USERNAME_FIELD));
    }

    public static WebElement getPassField(){
        return driver.findElement(By.name(LOGIN_PASS_FIELD));
    }

    public static WebElement getLoginButton(){
        return driver.findElement(By.xpath(LOGIN_BUTTON));
    }

    public static WebElement getLogInErrorMsg(){
        return driver.findElement(By.id(LOGIN_ERROR_MSG));
    }

    public static WebElement getForgetInfo(){
        return driver.findElement(By.xpath(FORGET_LOGIN_INFO_LINK));
    }

    public static WebElement getForgetForm(){
        return driver.findElement(By.id(FORGET_FORM));
    }

    public static WebElement getRegisterLink(){
        return driver.findElement(By.xpath(REGISTER_LINK));
    }

    public static WebElement getLogOutLink(){
        return driver.findElement(By.xpath(LOG_OUT));
    }

    public static WebElement getForgetFirstNameError(){
        return driver.findElement(By.id(FORGET_FIRSTNAME_ERROR_MSG));
    }

    public static WebElement getForgetLastNameError(){
        return driver.findElement(By.id(FORGET_LASTNAME_ERROR_MSG));
    }

    public static WebElement getForgetAddressError(){
        return driver.findElement(By.id(FORGET_ADDRESS_ERROR_MSG));
    }

    public static WebElement getForgetCityError(){
        return driver.findElement(By.id(FORGET_CITY_ERROR_MSG));
    }

    public static WebElement getForgetStateError(){
        return driver.findElement(By.id(FORGET_STATE_ERROR_MSG));
    }

    public static WebElement getForgetZipcodeError(){
        return driver.findElement(By.id(FORGET_ZIPCODE_ERROR_MSG));
    }

    public static WebElement getForgetSSNError(){
        return driver.findElement(By.id(FORGET_SSN_ERROR_MSG));
    }

    public static void logIn(String username, String pass) {

        getUserNameField().sendKeys(username);
        getPassField().sendKeys(pass);
        getLoginButton().click();

    }

    public static void logOut(){
        wait.until(ExpectedConditions.visibilityOf(getLogOutLink()));
        getLogOutLink().click();
    }

    public static void findLoginInfo(String name, String lastname, String address, String city,
                                     String state, String zip, String ssn){

        driver.findElement(By.id(FORGET_FIRSTNAME)).sendKeys(name);
        driver.findElement(By.id(FORGET_LASTNAME)).sendKeys(lastname);
        driver.findElement(By.id(FORGET_ADDRESS)).sendKeys(address);
        driver.findElement(By.id(FORGET_CITY)).sendKeys(city);
        driver.findElement(By.id(FORGET_STATE)).sendKeys(state);
        driver.findElement(By.id(FORGET_ZIPCODE)).sendKeys(zip);
        driver.findElement(By.id(FORGET_SSN)).sendKeys(ssn);
        driver.findElement(By.xpath(FIND_LOGIN_INFO_BUTTON)).click();

    }

}
