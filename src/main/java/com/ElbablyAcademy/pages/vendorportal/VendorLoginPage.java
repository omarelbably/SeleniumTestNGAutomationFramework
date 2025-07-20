package com.ElbablyAcademy.pages.vendorportal;

import com.ElbablyAcademy.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VendorLoginPage extends AbstractPage {
    private final By username= By.id("username");
    private final By password= By.id("password");
    private final By loginBtn = By.id("login");
    public VendorLoginPage(WebDriver driver) {
        super(driver);
    }
    public void enterUserCredentials(String usernameValue, String passwordValue){
        actions.enterText(username, usernameValue);
        actions.enterText(password, passwordValue);
    }
    public void clickOnLoginBtn(){
        actions.waitForClickabilityAndClick(loginBtn);
    }

    @Override
    public boolean isAt() {
        waits.waitForElementToBeVisible(username);
        return checks.elementIsDisplayed(username);
    }
}
