package com.ElbablyAcademy.pages.flightreservation;

import com.ElbablyAcademy.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlightConfirmationPage extends AbstractPage {
    public static final Logger log = LoggerFactory.getLogger(FlightConfirmationPage.class);
    private final By flightCost = By.xpath("//*[contains(text(), \"Total Price\")]/following-sibling::div/p");
    private final By flightConfirmationNumber = By.xpath("//*[contains(text(), \"Flight Confirmation\")]/following-sibling::div/p");
    public FlightConfirmationPage(WebDriver driver) {
        super(driver);
    }
    public String getPrice(){
        String confirmationNumber = actions.getText(flightConfirmationNumber);
        String flightTotalPrice = actions.getText(flightCost);
        log.info("flight confirmation number is {} ", confirmationNumber);
        log.info("flight total price is {}", flightTotalPrice);
        return  flightTotalPrice;
    }

    @Override
    public boolean isAt() {
        waits.waitForElementToBeVisible(flightConfirmationNumber);
        return checks.elementIsDisplayed(flightConfirmationNumber);
    }
}
