package com.globant.test;

import com.globant.pages.EspnMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTests {

    MyDriver driverBrowser;

    private EspnMethod espnBase;

    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser", "url"})
    public void beforeSuite(@Optional("Chrome") String browser, @Optional("https://www.espn.com/?src=com&_adblock=true") String url) {
        driverBrowser = new MyDriver(browser);
        WebDriver driver = driverBrowser.getDriver();
        driver.manage().window().maximize();
        driver.get(url);
        espnBase = new EspnMethod(driver);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        espnBase.dispose();
    }

    public EspnMethod getEspnMethod() {
        return espnBase;
    }
}
