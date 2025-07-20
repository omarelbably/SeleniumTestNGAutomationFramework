package com.ElbablyAcademy.pages.vendorportal;

import com.ElbablyAcademy.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashboardPage extends AbstractPage {
    private static final Logger log = LoggerFactory.getLogger(DashboardPage.class);
    private final By monthlyEarningElement = By.id("monthly-earning");
    private final By annualEarnings = By.id("annual-earning");
    private final By profitMargin = By.id("profit-margin");
    private final By availableInventory = By.id("available-inventory");
    private final By searchInput = By.cssSelector("[type=\"search\"]");
    private final By searchResultsCountElement = By.id("dataTable_info");
    private final By profilePictureBtn = By.cssSelector("#userDropdown");
    private final By logoutBtn = By.linkText("Logout");
    private final By logoutConfirmationBtn = By.cssSelector("[href=\"index.html\"]");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }
    public String getMonthlyEarnings(){
        return actions.getText(monthlyEarningElement);
    }
    public String getAnnualEarnings(){
        return actions.getText(annualEarnings);
    }
    public String getProfitMargin(){
        return actions.getText(profitMargin);
    }
    public String getAvailableInventory(){
        return actions.getText(availableInventory);
    }
    public void searchOrderHistory(String keyword){
        actions.enterText(searchInput, keyword);
    }
    public int getSearchResultsCount(){
        String resultText = actions.getText(searchResultsCountElement);
        String[] arr = resultText.split(" ");
        int count = Integer.parseInt(arr[5]);
        log.info("Results count is {} ", count);
        return count;
    }
    public void logout(){
        actions.waitForClickabilityAndClick(profilePictureBtn);
        actions.waitForClickabilityAndClick(logoutBtn);
        actions.waitForClickabilityAndClick(logoutConfirmationBtn);
    }

    @Override
    public boolean isAt() {
        waits.waitForElementToBeVisible(monthlyEarningElement);
        return checks.elementIsDisplayed(monthlyEarningElement);
    }
}
