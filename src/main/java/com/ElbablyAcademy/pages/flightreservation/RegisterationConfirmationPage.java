package com.ElbablyAcademy.pages.flightreservation;

import com.ElbablyAcademy.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterationConfirmationPage extends AbstractPage {
    private final By goToFlightsSearchBtn = By.id("go-to-flights-search");

    public RegisterationConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public void goToFlightSearchBtn() {
        actions.waitForClickabilityAndClick(goToFlightsSearchBtn);
    }

    @Override
    public boolean isAt() {
        waits.waitForElementToBeVisible(goToFlightsSearchBtn);
        return checks.elementIsDisplayed(goToFlightsSearchBtn);
    }
}
