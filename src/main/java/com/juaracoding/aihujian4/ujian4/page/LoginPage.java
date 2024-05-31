package com.juaracoding.aihujian4.ujian4.page;
/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-233.15026.9, built on March 21, 2024
@Author ajirohimat aih a.k.a Aji Rohimat
Java Developer
Created on 03/05/24 15.25
@Last Modified 03/05/24 15.25
Version 1.0
*/

import com.juaracoding.aihujian4.ujian4.connection.Constants;
import com.juaracoding.aihujian4.ujian4.connection.DriverSingleton;
import com.juaracoding.aihujian4.ujian4.util.GlobalFunction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private static WebDriver driver;
    @FindBy (xpath = "//input[@id='username']")
    private WebElement txtFieldUsername;

    @FindBy (xpath = "//input[@id='password']")
    private WebElement txtFieldPassword;

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement btnSubmit;
    @FindBy (xpath = "//li[normalize-space()='Username Tidak Boleh Kosong']")
    private WebElement notifLoginError;
    @FindBy (xpath = "//li[@class='error']")
    private WebElement notifLoginErrorUsername;
    @FindBy (xpath = "//li[@class='error']")
    private WebElement notifLoginErrorPass;
    @FindBy (xpath = "//h1[normalize-space()='Sign In']")
    private static WebElement labelLogin;

    @FindBy (xpath = "//h1[normalize-space()='Sign In']")
    private static WebElement labelSignIn;

    public LoginPage (){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }
    public LoginPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputUsername(String username){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(txtFieldUsername)).sendKeys(username);
        }catch (Exception e){
            System.out.println("Komponen Text Field Username Tidak Ditemukan !!");
        }
    }

    public void inputPassword(String password) {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try {
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(txtFieldPassword)).sendKeys(password);
        } catch (Exception e) {
            System.out.println("Komponen Text Field Password Tidak Ditemukan !!");
        }
    }
    public void clickLogin(){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(btnSubmit)).click();
        }catch (Exception e){
            System.out.println("Komponen Tombol Tidak Ditemukan !!");
        }
    }

    public void clear(){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            /** Set Field Password Empty String */
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(txtFieldPassword)).clear();
            /** Set Field Username Empty String */
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(txtFieldUsername)).clear();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public String notificationLoginError(){
        return notifLoginError ==null?"": new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(notifLoginError)).getText();
    }
    public String notificationLoginErrorUsernam(){
        return notifLoginErrorUsername ==null?"": new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(notifLoginErrorUsername)).getText();
    }
    public String notificationLoginErrorPass(){
        return notifLoginErrorPass ==null?"": new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(notifLoginErrorPass)).getText();
    }

    public static String loginFormValidation(){
        return labelLogin==null?"":new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(labelLogin)).getText();
    }
    public static String SignInValidation(){
        return labelSignIn==null?"":new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(labelSignIn)).getText();
    }
}
