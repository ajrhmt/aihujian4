package com.juaracoding.aihujian4.ujian4.impl;
/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-233.15026.9, built on March 21, 2024
@Author ajirohimat aih a.k.a Aji Rohimat
Java Developer
Created on 03/05/24 15.27
@Last Modified 03/05/24 15.27
Version 1.0
*/

import com.juaracoding.aihujian4.ujian4.connection.Constants;
import com.juaracoding.aihujian4.ujian4.connection.DriverSingleton;
import com.juaracoding.aihujian4.ujian4.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginNegatif {
    public static WebDriver driver;
    private LoginPage loginPage;

    @BeforeTest
    public void initCase() {
        DriverSingleton.getInstance(Constants.CHROME);
        this.driver = DriverSingleton.getDriver();
        this.driver.get(Constants.URL_LOGIN);
        loginPage = new LoginPage(driver);

    }

    @Test(priority = 0)
    public void emptyLogin() {
        loginPage.clear();
        loginPage.inputUsername("");
        loginPage.inputPassword("");
        loginPage.clickLogin();
        String strLoginError = loginPage.notificationLoginError();
        System.out.println("Validation Login Error Empty String " + strLoginError);
        Assert.assertEquals("username tidak boleh kosong", strLoginError);
    }

    @Test(priority = 1)
    public void invalidPassword() {
        loginPage.clear();
        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin@123");//correct pass Admin@123
        loginPage.clickLogin();
        Assert.assertEquals("invalid password", loginPage.notificationLoginErrorPass());
    }

    @Test(priority = 2)
    public void invalidUsername() {
        loginPage.clear();
        loginPage.inputUsername("admin");
        loginPage.inputPassword("Admin@123");
        loginPage.clickLogin();
        Assert.assertEquals("invalid username", loginPage.notificationLoginErrorUsernam());
    }

    @Test(priority = 3)
    public void invalidLogin() {
        loginPage.clear();//STEP-1
        loginPage.inputUsername("admin");//STEP-2
        loginPage.inputPassword("admin@123");//STEP-3
        loginPage.clickLogin();//STEP-4
        String strUsernamePasswordInvalid = loginPage.notificationLoginErrorUsernam();//STEP-5
        System.out.println("Username & Password Salah, tidak bisa Log In "+ strUsernamePasswordInvalid);
        Assert.assertEquals("invalid username", strUsernamePasswordInvalid);//STEP-6
    }

    @AfterTest
    public void closeDriver() {
        DriverSingleton.closeObjectInstance();
    }
}
