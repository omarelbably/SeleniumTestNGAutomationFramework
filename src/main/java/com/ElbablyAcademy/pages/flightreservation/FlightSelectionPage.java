package com.ElbablyAcademy.pages.flightreservation;

import com.ElbablyAcademy.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightSelectionPage extends AbstractPage {
    private final By departureFlightOptions = By.name("departure-flight");
    private final By arrivalFlightOptions = By.name("arrival-flight");
    private final By confirmFlightBtn = By.id("confirm-flights");
    public FlightSelectionPage(WebDriver driver) {
        super(driver);
    }

    public void selectFlights(){
        actions.clickOnRandomValue(departureFlightOptions);
        actions.clickOnRandomValue(arrivalFlightOptions);
    }
    public void clickOnConfirmFlightBtn()
    {
        actions.waitForClickabilityAndClick(confirmFlightBtn);
    }
    @Override
    public boolean isAt() {
        waits.waitForElementToBeVisible(confirmFlightBtn);
        return checks.elementIsDisplayed(confirmFlightBtn);
    }
}
