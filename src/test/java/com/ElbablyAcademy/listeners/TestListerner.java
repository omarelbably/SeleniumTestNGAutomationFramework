package com.ElbablyAcademy.listeners;

import com.ElbablyAcademy.util.propertiesloader.ConfigManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListerner implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result){
    TakesScreenshot driver = (TakesScreenshot) result.getTestContext().getAttribute(ConfigManager.getProperty("driver"));
    String screenshot = driver.getScreenshotAs(OutputType.BASE64);
    String htmlImageFormat = "<img width=700px src='data:image/png;base64,%s' />";
    String htmlImage = String.format(htmlImageFormat, screenshot);
    Reporter.log(htmlImage);
    }
}
