package com.ElbablyAcademy.tests.vendorportal;

import com.ElbablyAcademy.pages.vendorportal.DashboardPage;
import com.ElbablyAcademy.pages.vendorportal.VendorLoginPage;
import com.ElbablyAcademy.tests.AbstractTest;
import com.ElbablyAcademy.tests.vendorportal.testDataModel.VendorPortalTestData;
import com.ElbablyAcademy.util.JsonUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VendorPortalTest extends AbstractTest {
    private VendorLoginPage vendorLoginPage;
    private DashboardPage dashboardPage;
    private VendorPortalTestData testData;
    @BeforeTest
    @Parameters("testDataPath")
    public void setup(String testDataPath){
        this.vendorLoginPage = new VendorLoginPage(driver);
        this.dashboardPage = new DashboardPage(driver);
        this.testData = JsonUtils.getTestData(testDataPath, VendorPortalTestData.class);
    }
    @Test
    public void login(){
        vendorLoginPage.goToUrl("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html#");
        Assert.assertTrue(vendorLoginPage.isAt());
        vendorLoginPage.enterUserCredentials(testData.username(), testData.password());
        vendorLoginPage.clickOnLoginBtn();
    }
    @Test(dependsOnMethods = "login")
    public void dashboardTest(){
        Assert.assertTrue(dashboardPage.isAt());
        // Finance metrics
        Assert.assertEquals(dashboardPage.getMonthlyEarnings(), testData.monthlyEarnings());
        Assert.assertEquals(dashboardPage.getAnnualEarnings(), testData.annualEarnings());
        Assert.assertEquals(dashboardPage.getProfitMargin(), testData.profitMargin());
        Assert.assertEquals(dashboardPage.getAvailableInventory(), testData.availableInventory());

        // Order History
        dashboardPage.searchOrderHistory(testData.searchKeywords());
        Assert.assertEquals(dashboardPage.getSearchResultsCount(), testData.searchResultsCount());
    }
    @Test(dependsOnMethods = "dashboardTest")
    public void logout(){
        dashboardPage.logout();
        Assert.assertTrue(vendorLoginPage.isAt());
    }
}
