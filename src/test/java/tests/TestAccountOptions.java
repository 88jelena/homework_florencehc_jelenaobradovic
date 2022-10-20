package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.util.ArrayList;

import static objects.AccountPage.*;
import static objects.LoginPage.getLogInErrorMsg;
import static resources.Constants.*;

public class TestAccountOptions extends BaseTestClass{

    @BeforeMethod
    public void accountSetup(){
        getSiteMap().click();
    }

    @Test
    public void verifySiteMapLinks(){
        SoftAssert softAssert = new SoftAssert();
        ArrayList<String> accountServices = new ArrayList<String>();
        accountServices.add(OPEN_NEW_ACCOUNT);
        accountServices.add(ACCOUNT_OVERVIEW);
        accountServices.add(TRANSFER_FUNDS);
        accountServices.add(BILL_PAY);
        accountServices.add(FIND_TRANSACTIONS);
        accountServices.add(UPDATE_PROFILE);
        accountServices.add(REQUEST_LOAN);

        for(String locator : accountServices){
            WebElement el = driver.findElement(By.xpath(locator));
            String expectedMsg = el.getText();
            try {
                el.click();
            }
            catch(org.openqa.selenium.StaleElementReferenceException ex)
            {
                el.click();
            }
            String actualMsg = getLogInErrorMsg().getText();
            softAssert.assertTrue(actualMsg.contains(expectedMsg),
                    "Found: \n{"+ actualMsg + "}\n instead of: \n{"+ expectedMsg+ "}\n");

            wait.until(ExpectedConditions.visibilityOf(getSiteMap()));
            getSiteMap().click();
        }
        softAssert.assertAll();
    }

}
