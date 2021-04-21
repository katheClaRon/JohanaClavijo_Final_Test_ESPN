package com.globant.test;

import com.globant.pages.EspnMethod;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(ListenerClass.class)
public class GeneralTest extends BaseTests {

    WebDriver driver;

    @Test(priority = 1, description = "Create a new account", groups = {"itsnotest"})
    @Parameters({"firstName", "lastName", "email", "newPassword"})
    public void createAccount
            (@Optional("MyNameUno") String firstName, @Optional("MyLastName") String lastName, @Optional("MytestCreate29@gmail.com") String email, @Optional("Pass123*") String newpPassword) {
        EspnMethod espnBase = getEspnMethod();
        String nombreUser = espnBase.createAccount(firstName, lastName, email, newpPassword);
        System.out.println(nombreUser);
        Assert.assertEquals("Welcome MyNameUno!", nombreUser);
    }

    @Test(priority = 2, description = "Login a user", groups = {"Final"})
    @Parameters({"userNameP", "PassP"})
    public void LogInUser(@Optional("MytestCreate29@gmail.com") String userNameP, @Optional("Pass123*") String PassP) {
        EspnMethod espnBase = getEspnMethod();
        String nombreUser = espnBase.logInUser(userNameP, PassP);
        Assert.assertEquals("Welcome MyNameUno!", nombreUser);

    }

    @Test(priority = 3, description = "Logout account", groups = {"Final"})
    @Parameters({"userNameP", "PassP"})
    public void logOutProcess(@Optional("MytestCreate29@gmail.com") String userNameP, @Optional("Pass123*") String PassP) {
        EspnMethod espnBase = getEspnMethod();
        String nombreUser = espnBase.logOutUser(userNameP, PassP);
        Assert.assertTrue("Session closed", true);

    }

    @Test(priority = 4, description = "Delete account", groups = {"Final"})
    @Parameters({"userNameP", "PassP"})
    public void deleteAccount(@Optional("MytestCreate23@gmail.com") String userNameP, @Optional("Pass123*") String PassP) {
        EspnMethod espnBase = getEspnMethod();
        String nombreUser = espnBase.cancelAccount(userNameP, PassP);
        Assert.assertEquals("Account Deactivated", nombreUser);

    }

}
