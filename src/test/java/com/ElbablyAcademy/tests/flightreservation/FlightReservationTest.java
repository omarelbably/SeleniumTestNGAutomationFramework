package com.ElbablyAcademy.tests.flightreservation;

import com.ElbablyAcademy.pages.flightreservation.*;
import com.ElbablyAcademy.tests.AbstractTest;
import com.ElbablyAcademy.tests.flightreservation.testDataModel.FlightReservationTestData;
import com.ElbablyAcademy.util.JsonUtils;
import com.ElbablyAcademy.util.propertiesloader.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlightReservationTest extends AbstractTest {
    private FlightReservationTestData testData;
    @BeforeTest
    @Parameters("testDataPath")
    public void setup(String testDataPath){
        this.testData = JsonUtils.getTestData(testDataPath, FlightReservationTestData.class);
    }

    @Test
    public void userRegisterationPage(){
        RegisterationPage registerationPage = new RegisterationPage(driver);
        registerationPage.goToUrl(ConfigManager.getProperty("flightReservation.url"));
        Assert.assertTrue(registerationPage.isAt());
        registerationPage.enterUserDetails(testData.firstName(), testData.lastName());
        registerationPage.enterUserCredentials(testData.email(), testData.password());
        registerationPage.enterUserAddress(testData.street(), testData.city(), testData.zip());
        registerationPage.clickOnRegisterationBtn();
    }
    @Test(dependsOnMethods = "userRegisterationPage")
    public void registerationConfirmationTest(){
        RegisterationConfirmationPage registerationConfirmationPage = new RegisterationConfirmationPage(driver);
        Assert.assertTrue(registerationConfirmationPage.isAt());
        registerationConfirmationPage.goToFlightSearchBtn();
    }
    @Test(dependsOnMethods =  "registerationConfirmationTest")
    public void flightSearchTest(){
        FlightSearchPage flightSearchPage = new FlightSearchPage(driver);
        Assert.assertTrue(flightSearchPage.isAt());
        flightSearchPage.selectPassenger(testData.passengersCount());
        flightSearchPage.clickOnSearchFlightBtn();
    }
    @Test(dependsOnMethods = "flightSearchTest")
    public void flightSelectionTest(){
        FlightSelectionPage flightSelectionPage = new FlightSelectionPage(driver);
        Assert.assertTrue(flightSelectionPage.isAt());
        flightSelectionPage.selectFlights();
        flightSelectionPage.clickOnConfirmFlightBtn();
    }
    @Test(dependsOnMethods = "flightSelectionTest")
    public void flightReservationConfirmationTest(){
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        Assert.assertTrue(flightConfirmationPage.isAt());
        Assert.assertEquals(flightConfirmationPage.getPrice(), testData.expectedCost());
    }
}
