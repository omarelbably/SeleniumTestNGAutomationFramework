package com.ElbablyAcademy.pages.flightreservation;

import com.ElbablyAcademy.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightSearchPage extends AbstractPage {
    private final By passengerDropdownList = By.id("passengers");
    private final By searchFlightBtn = By.id("search-flights");
    public FlightSearchPage(WebDriver driver) {
        super(driver);
    }
    public void selectPassenger(String passengerValue){
        actions.selectFromDropdownListByValue(passengerDropdownList, passengerValue);
    }
    public void clickOnSearchFlightBtn(){
        actions.waitForClickabilityAndClick(searchFlightBtn);
    }
    @Override
    public boolean isAt() {
        waits.waitForElementToBeVisible(passengerDropdownList);
        return checks.elementIsDisplayed(passengerDropdownList);
    }
}
