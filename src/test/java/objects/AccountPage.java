package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static resources.Constants.*;

public class AccountPage extends BaseClass{


    public static WebElement getSiteMap(){
        return driver.findElement(By.xpath(SITE_MAP));
    }
}
