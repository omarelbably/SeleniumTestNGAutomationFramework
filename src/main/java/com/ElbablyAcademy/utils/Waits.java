package com.ElbablyAcademy.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private final WebDriver driver;
    public Waits(WebDriver driver){
        this.driver = driver;
    }
    public void waitForElementToBeVisible(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
