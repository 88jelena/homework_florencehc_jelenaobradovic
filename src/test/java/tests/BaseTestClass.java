package tests;

import objects.BaseClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners(objects.TestStatusListener.class)
public class BaseTestClass extends BaseClass {

    @BeforeTest
    public void startTest(){
        setup();
        setUpWait();
    }

    @BeforeMethod
    public void generateUserData(){
        generateData();
    }

    @AfterTest
    public void stopTest(){
        teardown();
    }

}
