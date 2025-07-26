package com.ElbablyAcademy.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class  Frames {
    WebDriver driver;

    public Frames(WebDriver driver){
        this.driver = driver;
    }

    public void getFrame(String frameNameOrId){
        driver.switchTo().frame(frameNameOrId);
    }
}
