package com.ElbablyAcademy.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checks {
    private final WebDriver driver;
    public Checks(WebDriver driver){
        this.driver = driver;
    }
    public boolean elementIsDisplayed(By locator){
        return this.driver.findElement(locator).isDisplayed();
    }

}
