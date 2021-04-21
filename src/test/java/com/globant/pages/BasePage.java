package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver pDriver) {
        this.driver = pDriver;
        PageFactory.initElements(driver, this);
    }

    public WebDriverWait getWait() {
        wait = new WebDriverWait(driver, 50);
        return wait;
    }

    public void waitTime (int mls){
        try {
            Thread.sleep(mls);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void dispose() {
        if (driver != null) {
            driver.quit();
        }
    }

}
