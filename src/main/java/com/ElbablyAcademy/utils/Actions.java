package com.ElbablyAcademy.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

public class Actions {
    private final WebDriver driver;
    private final Waits waits;
    public Actions(WebDriver driver){
        this.driver = driver;
        this.waits = new Waits(driver);
    }
    public void waitForClickabilityAndClick(By locator){
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        boolean clicked = wait.until(driver1 -> {
            try {
                // Safeguard: Wait for element to be clickable
                WebDriverWait clickableWait = new WebDriverWait(driver, Duration.ofSeconds(2));
                WebElement element = clickableWait.until(ExpectedConditions.elementToBeClickable(locator));
                // Scroll into view
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].scrollIntoView({block: 'center'});", element);
                // Check if in viewport
                boolean isInViewport = (Boolean) ((JavascriptExecutor) driver).executeScript(
                        "const rect = arguments[0].getBoundingClientRect();" +
                                "return (rect.top >= 0 && rect.left >= 0 && " +
                                "rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) && " +
                                "rect.right <= (window.innerWidth || document.documentElement.clientWidth));",
                        element);
                if (!isInViewport) {
                    System.out.println("Element is outside viewport. Retrying...");
                    return false;
                }
                // Try clicking the element safely
                try {
                    element.click();
                    System.out.println("Clicked element successfully.");
                    return true;
                } catch (WebDriverException e) {
                    System.out.println("Click failed, will retry: " + e.getClass().getSimpleName());
                    return false;
                }
            } catch (TimeoutException e) {
                System.out.println("Element not clickable yet. Retrying...");
                return false;
            } catch (Exception e) {
                System.out.println("Unhandled exception: " + e.getClass().getSimpleName());
                return false;
            }
        });
        if (!clicked) {
            throw new TimeoutException("Failed to click the element within timeout: " + locator.toString());
        }
    }
    public void enterText(By locator, String text) {
        waits.waitForElementToBeVisible(locator);
        try {
            this.driver.findElement(locator).clear();
            this.driver.findElement(locator).sendKeys(text);
        } catch (Exception e) {
            System.out.println("Element with locator {} is not clickable");
        }
    }
    public String getText(By locator){
        waits.waitForElementToBeVisible(locator);
        String text = "";
        try {
            return this.driver.findElement(locator).getText();
        }catch (Exception e){
            System.out.println("no text found");
        }
        return text;
    }
    public void clickOnRandomValue(By locator){
        int random = ThreadLocalRandom.current().nextInt(0, this.driver.findElements(locator).size());
        waitForElementToBeClickable(this.driver.findElements(locator).get(random));
    }
    public void selectFromDropdownListByValue(By locator, String valueName){
        Select select = new Select(this.driver.findElement(locator));
        select.selectByValue(valueName);
    }
    public void waitForElementToBeClickable(WebElement element1){
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        boolean clicked = wait.until(driver1 -> {
            try {
                // Safeguard: Wait for element to be clickable
                WebDriverWait clickableWait = new WebDriverWait(driver, Duration.ofSeconds(2));
                WebElement element = clickableWait.until(ExpectedConditions.elementToBeClickable(element1));
                // Scroll into view
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].scrollIntoView({block: 'center'});", element);
                // Check if in viewport
                boolean isInViewport = (Boolean) ((JavascriptExecutor) driver).executeScript(
                        "const rect = arguments[0].getBoundingClientRect();" +
                                "return (rect.top >= 0 && rect.left >= 0 && " +
                                "rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) && " +
                                "rect.right <= (window.innerWidth || document.documentElement.clientWidth));",
                        element);
                if (!isInViewport) {
                    System.out.println("Element is outside viewport. Retrying...");
                    return false;
                }
                // Try clicking the element safely
                try {
                    element.click();
                    System.out.println("Clicked element successfully.");
                    return true;
                } catch (WebDriverException e) {
                    System.out.println("Click failed, will retry: " + e.getClass().getSimpleName());
                    return false;
                }
            } catch (TimeoutException e) {
                System.out.println("Element not clickable yet. Retrying...");
                return false;
            } catch (Exception e) {
                System.out.println("Unhandled exception: " + e.getClass().getSimpleName());
                return false;
            }
        });
        if (!clicked) {
            throw new TimeoutException("Failed to click the element within timeout: " + element1.toString());
        }
    }
}
