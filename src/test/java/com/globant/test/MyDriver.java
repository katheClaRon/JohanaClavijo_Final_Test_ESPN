package com.globant.test;

import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class MyDriver {

    private WebDriver driver;

    public MyDriver (String browser) {

        switch (browser) {
            case ("remoteFirefox"):
                try {
                    driver = new RemoteWebDriver(new URL("https://www.espn.com/?src=com&_adblock=true"), DesiredCapabilities.firefox());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", "./src/test/resources/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                break;
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
