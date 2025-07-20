package com.ElbablyAcademy.pages;

import com.ElbablyAcademy.utils.Actions;
import com.ElbablyAcademy.utils.Checks;
import com.ElbablyAcademy.utils.Waits;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractPage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final Actions actions;
    protected final Checks checks;
    protected final Waits waits;
    protected final int WAIT_TIME_OUT = 60;

    public AbstractPage(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver);
        this.waits = new Waits(driver);
        this.checks = new Checks(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(this.WAIT_TIME_OUT));
    }
    public void goToUrl(String url) {
        this.driver.get(url);
    }
    public abstract boolean isAt();
}
