package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static resources.Constants.*;


public class RegisterPage extends BaseClass{

    public static WebElement getRegisterForm(){
        return driver.findElement(By.id(REGISTER_FORM));
    }

    public static WebElement getRegisterNameField(){
        return driver.findElement(By.id(REGISTER_FIRSTNAME_FIELD));
    }
    public static WebElement getRegisterNameFieldError(){
        return driver.findElement(By.id(REGISTER_FIRSTNAME_ERROR_MSG));
    }
    public static WebElement getRegisterLasNameField(){
        return driver.findElement(By.id(REGISTER_LASTNAME_FIELD));
    }
    public static WebElement getRegisterLastNameFieldError(){
        return driver.findElement(By.id(REGISTER_LASTNAME_ERROR_MSG));
    }
    public static WebElement getRegisterAddressField(){
        return driver.findElement(By.id(REGISTER_ADDRESS_FIELD));
    }
    public static WebElement getRegisterAddressFieldError(){
        return driver.findElement(By.id(REGISTER_ADDRESS_ERROR_MSG));
    }
    public static WebElement getRegisterCityField(){
        return driver.findElement(By.id(REGISTER_CITY_FIELD));
    }
    public static WebElement getRegisterCityFieldError(){
        return driver.findElement(By.id(REGISTER_CITY_ERROR_MSG));
    }
    public static WebElement getRegisterStateField(){
        return driver.findElement(By.id(REGISTER_STATE_FIELD));
    }
    public static WebElement getRegisterStateFieldError(){
        return driver.findElement(By.id(REGISTER_STATE_ERROR_MSG));
    }
    public static WebElement getRegisterZipField(){
        return driver.findElement(By.id(REGISTER_ZIPCODE_FIELD));
    }
    public static WebElement getRegisterZipFieldError(){
        return driver.findElement(By.id(REGISTER_ZIPCODE_ERROR_MSG));
    }
    public static WebElement getRegisterPhoneField(){
        return driver.findElement(By.id(REGISTER_PHONE_FIELD));
    }
    public static WebElement getRegisterSSNField(){
        return driver.findElement(By.id(REGISTER_SSN_FIELD));
    }
    public static WebElement getRegisterSSNFieldError(){
        return driver.findElement(By.id(REGISTER_SSN_ERROR_MSG));
    }
    public static WebElement getRegisterUserNameField(){
        return driver.findElement(By.id(REGISTER_USERNAME_FIELD));
    }
    public static WebElement getRegisterUserNameFieldError(){
        return driver.findElement(By.id(REGISTER_USERNAME_ERROR_MSG));
    }
    public static WebElement getRegisterPassField(){
        return driver.findElement(By.id(REGISTER_PASS_FIELD));
    }
    public static WebElement getRegisterPassFieldError(){
        return driver.findElement(By.id(REGISTER_PASS_ERROR_MSG));
    }
    public static WebElement getRegisterConfirmField(){
        return driver.findElement(By.id(REGISTER_CONFIRM_FIELD));
    }
    public static WebElement getRegisterConfirmFieldError(){
        return driver.findElement(By.id(REGISTER_CONFIRM_ERROR_MSG));
    }
    public static WebElement getRegisterButton(){
        return driver.findElement(By.xpath(REGISTER_BUTTON));
    }

    public static void registerUser(String name, String lastname, String address, String city,
                                     String state, String zip, String phone, String ssn, String username,
                                    String pass, String confirm){

        getRegisterNameField().sendKeys(name);
        getRegisterLasNameField().sendKeys(lastname);
        getRegisterAddressField().sendKeys(address);
        getRegisterCityField().sendKeys(city);
        getRegisterStateField().sendKeys(state);
        getRegisterZipField().sendKeys(zip);
        getRegisterPhoneField().sendKeys(phone);
        getRegisterSSNField().sendKeys(ssn);
        getRegisterUserNameField().sendKeys(username);
        getRegisterPassField().sendKeys(pass);
        getRegisterConfirmField().sendKeys(confirm);
        getRegisterButton().click();

    }


}
