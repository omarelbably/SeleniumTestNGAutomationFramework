package com.ElbablyAcademy.tests;

import com.ElbablyAcademy.listeners.TestListerner;
import com.ElbablyAcademy.util.propertiesloader.ConfigManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Listeners(TestListerner.class)
public abstract class AbstractTest {
    private static final Logger log = LoggerFactory.getLogger(AbstractTest.class);
    protected WebDriver driver;

    @BeforeSuite
    public void setupConfig(){
        ConfigManager.initialize();
    }
    @BeforeTest
    public void startDriver(ITestContext ctx) throws MalformedURLException {
        if(Boolean.parseBoolean(ConfigManager.getProperty("grid.enabled"))){
            this.driver = getRemoteDriver();
        }else {
            this.driver = getLocalDriver();
        }
        ctx.setAttribute(ConfigManager.getProperty("driver") ,this.driver);
    }
    private WebDriver getRemoteDriver() throws MalformedURLException {
        Capabilities capabilities;
        if(ConfigManager.getProperty("browser").equalsIgnoreCase("chrome")){
            capabilities = new ChromeOptions();
        }else{
            capabilities = new FirefoxOptions();
        }
        String urlFormat = ConfigManager.getProperty("grid.urlFormat");
        String hubHost = ConfigManager.getProperty("grid.hubHost");
        // to pass a value into a String
        String remoteUrl = String.format(urlFormat, hubHost);
        log.info("grid url: {}", remoteUrl);
        return new RemoteWebDriver(new URL(remoteUrl),capabilities);
    }

    private WebDriver getLocalDriver() {
        return switch (ConfigManager.getProperty("browser")) {
            case "chrome" -> new ChromeDriver(getChromeOptions());
            case "firefox" -> new FirefoxDriver(getFirefoxOptions());
            case "edge" -> new EdgeDriver(getEdgeOptions());
            default -> throw new IllegalArgumentException("Unsupported browser: " + ConfigManager.getProperty("browser"));
        };
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        // Add desired arguments
        options.addArguments(
                "--start-maximized",
                "--disable-extensions",
                "--disable-popup-blocking",
                "--disable-infobars",
                "--disable-dev-shm-usage",
                "--no-sandbox",
                "--disable-notifications",
                "--disable-translate",
                "--disable-save-password-bubble",
                "--incognito",
//                "--headless=new",
                "--window-size=1920,1080",
                "--remote-allow-origins=*"
        );
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", "C:\\Downloads"); // customize as needed
        prefs.put("download.prompt_for_download", false);
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("safebrowsing.enabled", true);
        options.setExperimentalOption("prefs", prefs);

        return options;
    }

    private FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        // Core arguments
        options.addArguments(
                "--width=1920",
                "--height=1080",
                "--private",                  // Incognito mode
                "--disable-popup-blocking",
                "--disable-infobars"
        );
        FirefoxProfile profile = getFirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        options.setProfile(profile);
        return options;
    }

    private static FirefoxProfile getFirefoxProfile() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir", "C:\\Downloads");
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "application/pdf,application/octet-stream");
        profile.setPreference("pdfjs.disabled", true);
        profile.setPreference("dom.webnotifications.enabled", false);
        return profile;
    }

    public EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        // Core arguments
        options.addArguments(
                "--start-maximized",
                "--disable-extensions",
                "--disable-popup-blocking",
                "--disable-notifications",
                "--inprivate",
//                "--headless=new",
                "--window-size=1920,1080"
        );
//        Map<String, Object> prefs = new HashMap<>();
//        prefs.put("download.default_directory", "C:\\Downloads");
//        prefs.put("download.prompt_for_download", false);
//        prefs.put("profile.default_content_settings.popups", 0);
//        prefs.put("safebrowsing.enabled", true);
//        options.setExperimentalOption("prefs", prefs);

        return options;
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}
