package com.globant.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.interactions.Action;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class EspnMethod extends BasePage {

    WebDriver driver;

    @FindBy(id = "global-user-trigger")
    private WebElement userProfile;

    @FindBy(css = ".user .account-management > li:nth-of-type(7) > a")
    private WebElement loginProfile;

    @FindBy(css = ".btn.btn-secondary.ng-isolate-scope")
    private WebElement signUp;

    @FindBy(css = "input[name='firstName']")
    private WebElement firstName;

    @FindBy(css = "input[name='lastName']")
    private WebElement lastName;

    @FindBy(css = "input[name='email']")
    private WebElement email;

    @FindBy(css = "input[name='newPassword']")
    private WebElement newPassword;

    @FindBy(css = ".block.ng-scope.show-password-action > .checkbox > .name.ng-isolate-scope")
    private WebElement showBox;

    @FindBy(css = ".btn.btn-primary.ng-isolate-scope.ng-scope")
    private WebElement confirmedSignUP;

    @FindBy(css = "#did-ui-view > div > section > section > form > section > div:nth-child(1) > div > label > span.input-wrapper > input")
    private WebElement userName;

    @FindBy(css = "#did-ui-view > div > section > section > form > section > div:nth-child(2) > div > label > span.input-wrapper > input")
    private WebElement passwordAcess;

    @FindBy(css = ".btn.btn-primary.btn-submit.ng-isolate-scope")
    private WebElement logInUser;

    @FindBy(css = "li[class=user] li[class=display-user]")
    private WebElement nameValidate;

    @FindBy(css = ".user .account-management  .small")
    private WebElement logOutProfile;

    @FindBy(css = ".tools .account-management > .display-user")
    private WebElement displayUser;

    @FindBy(css = ".user .account-management > li:nth-of-type(5) > a")
    private WebElement espnProfiler;

    @FindBy(css = "a#cancel-account")
    private WebElement deleteAccount;

    @FindBy(css = ".btn.btn-primary.ng-isolate-scope")
    private WebElement saveDelete;

    @FindBy(css = ".ng-isolate-scope.title.title-primary")
    private WebElement confirmedDelete;

    public EspnMethod(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String createAccount(String firstNameP, String lastNameP, String emailP, String newPassP) {

        WebDriverWait waitprofile = new WebDriverWait(driver, 40);

        Actions actions = new Actions(driver);
        actions.moveToElement(userProfile);
        waitTime(3000);
        actions.moveToElement(loginProfile);
        actions.click().build().perform();

        waitprofile.until(ExpectedConditions.elementToBeClickable(userProfile));

        String disneyIframeSign = "disneyid-iframe";

        driver.switchTo().frame(disneyIframeSign);

        WebDriverWait waitCreateAccount = new WebDriverWait(driver, 30);
        waitCreateAccount.until(ExpectedConditions.elementToBeClickable(signUp));

        signUp.click();
        waitTime(2000);
        firstName.sendKeys(firstNameP);
        lastName.sendKeys(lastNameP);
        email.sendKeys(emailP);
        newPassword.sendKeys(newPassP);
        showBox.click();
        confirmedSignUP.click();

        driver.switchTo().defaultContent();

        actions.moveToElement(userProfile);
        waitprofile.until(ExpectedConditions.elementToBeClickable(userProfile));
        waitTime(2000);

        String nameTitle = nameValidate.getText();

        return nameTitle;
    }

    public String logInUser(String emailP, String newPassP) {


        WebDriverWait waitprofile = new WebDriverWait(driver, 30);
        Actions actions = new Actions(driver);
        actions.moveToElement(userProfile);
        waitTime(6000);
        actions.moveToElement(loginProfile);
        actions.click().build().perform();

        waitprofile.until(ExpectedConditions.elementToBeClickable(userProfile));

        String disneyIframeSign = "disneyid-iframe";
        driver.switchTo().frame(disneyIframeSign);

        waitTime(2000);
        userName.sendKeys(emailP);
        passwordAcess.sendKeys(newPassP);
        waitprofile.until(ExpectedConditions.elementToBeClickable(logInUser));
        logInUser.click();
        waitTime(5000);

        actions.moveToElement(userProfile);
        waitprofile.until(ExpectedConditions.elementToBeClickable(userProfile));
        actions.moveToElement(nameValidate);

        String nameTitle = nameValidate.getText();

        logOutUser(emailP, newPassP);

        return nameTitle;

    }

    public String logOutUser(String userNameP, String PassP) {

        logInUser(userNameP, PassP);

        WebDriverWait waitprofile = new WebDriverWait(driver, 20);

        Actions actions = new Actions(driver);
        actions.moveToElement(userProfile);
        waitTime(3000);
        actions.moveToElement(logOutProfile);
        actions.click().build().perform();
        waitprofile.until(ExpectedConditions.elementToBeClickable(userProfile));

        actions.moveToElement(userProfile);
        waitprofile.until(ExpectedConditions.elementToBeClickable(userProfile));
        actions.moveToElement(nameValidate);

        return nameValidate.getText();
    }

    public String cancelAccount(String userNameP, String PassP) {

        logInUser(userNameP, PassP);

        WebDriverWait waitprofile = new WebDriverWait(driver, 30);
        Actions actions = new Actions(driver);
        actions.moveToElement(userProfile);
        waitTime(6000);
        actions.moveToElement(espnProfiler);
        actions.click().build().perform();

        waitprofile.until(ExpectedConditions.elementToBeClickable(userProfile));

        String disneyIframeSign = "disneyid-iframe";
        driver.switchTo().frame(disneyIframeSign);

        waitTime(4000);
        deleteAccount.click();
        saveDelete.click();

        logInUser(userNameP, PassP);

        waitprofile.until(ExpectedConditions.elementToBeClickable(confirmedDelete));

        driver.switchTo().frame(disneyIframeSign);

        waitTime(2000);
        confirmedDelete.getText();

        String nameDelete = confirmedDelete.getText();

        return nameDelete;
    }
}
