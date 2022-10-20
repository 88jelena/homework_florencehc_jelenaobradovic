package objects;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.Constants;
import resources.UserRegistrationData;

public abstract class BaseClass {


    public static WebDriver driver;
    public static WebDriverWait wait;
    public static UserRegistrationData user;


    public static void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(Constants.HOMEPAGE_URL);

    }

    public static void setUpWait(){
        wait = new WebDriverWait(driver, 15);

    }

    public static void teardown(){
        driver.manage().deleteAllCookies();
        driver.close();
    }

    public void generateData() {

        Faker fakeData = new Faker();
        user = new UserRegistrationData();
        user.setFirstname(fakeData.name().firstName());
        user.setLastname(fakeData.name().lastName());
        user.setAddress(fakeData.address().fullAddress());
        user.setCity(fakeData.address().city());
        user.setState(fakeData.address().state());
        user.setZipcode(fakeData.address().zipCode());
        user.setPhone(fakeData.phoneNumber().cellPhone());
        user.setSsn(fakeData.phoneNumber().phoneNumber());
        user.setUsername(fakeData.app().author());
        user.setPass(fakeData.funnyName().name());
    }

    public void failedTestScrSh(String testMethodName){
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Date d = new Date();
        String TimeStamp = d.toString().replace(":", "_").replace(" ", "_");
        try{
            FileUtils.copyFile(srcFile, new File("test-output/test-output "+ testMethodName + "_" + TimeStamp + ".png"));
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
    }

}
