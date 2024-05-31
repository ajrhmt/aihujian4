package com.juaracoding.aihujian4.ujian4.impl;
/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-233.15026.9, built on March 21, 2024
@Author ajirohimat aih a.k.a Aji Rohimat
Java Developer
Created on 07/05/24 19.48
@Last Modified 07/05/24 19.48
Version 1.0
*/

import com.juaracoding.aihujian4.ujian4.connection.Constants;
import com.juaracoding.aihujian4.ujian4.connection.DriverSingleton;
import com.juaracoding.aihujian4.ujian4.page.HomePage;
import com.juaracoding.aihujian4.ujian4.page.LoginPage;
import com.juaracoding.aihujian4.ujian4.page.Soal11;
import com.juaracoding.aihujian4.ujian4.util.GlobalFunction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Step1Soal11 {
    public static WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private Soal11 soal11;
    private RunnerUjian runnerUjian;

    @BeforeTest
    public void initCase() {
        runnerUjian = new RunnerUjian();
        DriverSingleton.getInstance(Constants.CHROME);
        this.driver = DriverSingleton.getDriver();
        this.driver.get(Constants.URL_LOGIN);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        soal11 = new Soal11(driver);
    }

    @Test(priority = 0)
    public void validLogin() {
        loginPage.clear();//STEP-1
        loginPage.inputUsername("Admin");//STEP-2
        loginPage.inputPassword("Admin@123");//STEP-3
        loginPage.clickLogin();//STEP-4
        String strValidation = homePage.homePageValidation();
        Assert.assertEquals("4 Fitur Unggulan", strValidation);//STEP-5
    }
    @Test(priority = 1)
    public void homeToSoal11() {
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("arguments[0].click()", homePage.goToMenuSoal11());
    }

    @Test(priority = 2)
    public void inputDataSoal11(){
        soal11.inputNamaDepan(runnerUjian.getNamaDepan());//STEP-1
        soal11.inputNamaBelakang(runnerUjian.getNamaBelakang());//STEP-2
        soal11.inputPassword(runnerUjian.getPassWord()); // STEP-3
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");// STEP-4
        soal11.inputAlamatLengkap(runnerUjian.getAlaMat()); //STEP-5
        soal11.inputNoHP(runnerUjian.getNoHp()); //STEP-6
        soal11.inputEmail(runnerUjian.getEmail());//STEP-7
        soal11.clickSubmit();//STEP-8
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");//STEP-9
        // STEP-10 Validasi Seluruh Inputan
        String strNamaDepan = soal11.validationND();
        String strNamaBelakang = soal11.validationNB();
        String strPass = soal11.validationPass();
        String strAlamatLengkap = soal11.validationAlamat();
        String strNoHp = soal11.validationNoHp();
        String strEmail = soal11.validationEmail();

        Assert.assertEquals(runnerUjian.getNamaDepan(),strNamaDepan);
        Assert.assertEquals(runnerUjian.getNamaBelakang(),strNamaBelakang);
        Assert.assertEquals(runnerUjian.getPassWord(),strPass);
        Assert.assertEquals(runnerUjian.getAlaMat(),strAlamatLengkap);
        Assert.assertEquals("+62"+ runnerUjian.getNoHp(),strNoHp);
        Assert.assertEquals(runnerUjian.getEmail(),strEmail);
        GlobalFunction.delay(2);
        System.out.println("Form sudah sesuai");
    }

    @AfterTest
    public void closeDriver(){
        DriverSingleton.closeObjectInstance();
    }
}
