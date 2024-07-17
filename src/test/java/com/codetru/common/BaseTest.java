package com.codetru.common;

import com.Japfu.driver.DriverManager;
import com.Japfu.driver.TargetFactory;
import com.Japfu.helpers.PropertiesHelpers;
import com.codetru.listeners.TestListener;
import com.codetru.project.Japfu.CommonPageCICA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class BaseTest extends CommonPageCICA {

    @Parameters("BROWSER")
    @BeforeTest
    public void createDriver(@Optional("chrome") String browser) {
        WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance(browser));
        DriverManager.setDriver(driver);
        driver.manage().window().maximize();
    }

//    @AfterTest(alwaysRun = true)
//    public void closeDriver() {
//        DriverManager.quit();
//    }

    public WebDriver createBrowser(@Optional("chrome") String browser) {
        PropertiesHelpers.loadAllFiles();
        WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance(browser));
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
        return DriverManager.getDriver();
    }

}