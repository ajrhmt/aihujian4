package com.juaracoding.aihujian4.ujian4.impl;
/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-233.15026.9, built on March 21, 2024
@Author ajirohimat aih a.k.a Aji Rohimat
Java Developer
Created on 03/05/24 15.26
@Last Modified 03/05/24 15.26
Version 1.0
*/

import com.juaracoding.aihujian4.ujian4.connection.Constants;
import com.juaracoding.aihujian4.ujian4.connection.DriverSingleton;
import com.juaracoding.aihujian4.ujian4.page.HomePage;
import com.juaracoding.aihujian4.ujian4.page.LoginPage;
import com.juaracoding.aihujian4.ujian4.util.GlobalFunction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *  URL : http://localhost:8085
 */

public class LoginPositif {
    public static WebDriver driver;
    private LoginPage loginPage ;
    private HomePage homePage;

        @BeforeTest
        public void initCase(){
            DriverSingleton.getInstance(Constants.CHROME);
            this.driver = DriverSingleton.getDriver();
            this.driver.get(Constants.URL_LOGIN);
            loginPage = new LoginPage(driver);
            homePage = new HomePage(driver);
        }
        @Test (priority = 0)
        public void validLogin(){
            loginPage.clear();//STEP-1
            loginPage.inputUsername("Admin");//STEP-2
            loginPage.inputPassword("Admin@123");//STEP-3
            loginPage.clickLogin();//STEP-4
            String strValidation = homePage.homePageValidation();
            /** tambahkan step logout */
            Assert.assertEquals("4 Fitur Unggulan",strValidation);//STEP-5
        }

        @Test (priority = 1)
        public void logout(){
            JavascriptExecutor js = (JavascriptExecutor) this.driver;
            js.executeScript("arguments [0].click()", HomePage.logout());
            GlobalFunction.delay(3);
            Assert.assertEquals("Sign In", loginPage.loginFormValidation());
            System.out.println("Logo Sign In Terlihat, Berhasil Log Out");
        }

        @AfterTest
        public void closeDriver(){
            DriverSingleton.closeObjectInstance();
        }
}
