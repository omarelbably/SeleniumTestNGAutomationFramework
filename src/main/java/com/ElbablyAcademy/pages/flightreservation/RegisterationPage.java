package com.ElbablyAcademy.pages.flightreservation;

import com.ElbablyAcademy.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterationPage extends AbstractPage {
    private final By firstNameInputField = By.id("firstName");
    private final By lastNameInputField = By.id("lastName");
    private final By emailInputField = By.id("email");
    private final By passwordInputField = By.id("password");
    private final By streetInputField = By.name("street");
    private final By cityInputField = By.name("city");
    private final By zipInputField = By.name("zip");
    private final By registerBtn = By.id("register-btn");

    public RegisterationPage(WebDriver driver) {
        super(driver);
    }

    public void enterUserDetails(String firstName, String lastName) {
        actions.enterText(firstNameInputField, firstName);
        actions.enterText(lastNameInputField, lastName);
    }

    public void enterUserCredentials(String email, String password) {
        actions.enterText(emailInputField, email);
        actions.enterText(passwordInputField, password);
    }

    public void enterUserAddress(String streeName, String cityName, String zipCode) {
        actions.enterText(streetInputField, streeName);
        actions.enterText(cityInputField, cityName);
        actions.enterText(zipInputField, zipCode);
    }

    public void clickOnRegisterationBtn() {
        actions.waitForClickabilityAndClick(registerBtn);
    }

    @Override
    public boolean isAt() {
        waits.waitForElementToBeVisible(firstNameInputField);
        return checks.elementIsDisplayed(firstNameInputField);
    }
}
