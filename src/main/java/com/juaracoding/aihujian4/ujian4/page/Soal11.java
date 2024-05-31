package com.juaracoding.aihujian4.ujian4.page;
/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-233.15026.9, built on March 21, 2024
@Author ajirohimat aih a.k.a Aji Rohimat
Java Developer
Created on 07/05/24 19.47
@Last Modified 07/05/24 19.47
Version 1.0
*/

import com.juaracoding.aihujian4.ujian4.connection.Constants;
import com.juaracoding.aihujian4.ujian4.util.GlobalFunction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Soal11 {
    private static WebDriver driver;
    @FindBy(xpath = "//h1[normalize-space()='Ujian Selenium']")
    private WebElement labelMenuSoal11;

    @FindBy(xpath = "//input[@id='namaDepan']")
    private WebElement fieldNamaDepan;
    @FindBy(xpath = "//input[@id='namaBelakang']")
    private WebElement fieldNamaBelakang;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement fieldPassword;
    @FindBy(xpath = "//textarea[@id='alamatLengkap']")
    private WebElement fieldAlamat;
    @FindBy(xpath = "//input[@id='noHp']")
    private WebElement fieldNoHp;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement fieldEmail;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSubmit;

    @FindBy(xpath = "//span[@id='xnamadepan']")
    private static WebElement expctNamaDepan;

    @FindBy(xpath = "//span[@id='xnamabelakang']")
    private static WebElement expctNamaBelakang;

    @FindBy(xpath = "//span[@id='xpassword']")
    private static WebElement expctPass;

    @FindBy(xpath = "//span[@id='xalamatlengkap']")
    private static WebElement expctAlamat;

    @FindBy(xpath = "//span[@id='xnohp']")
    private static WebElement expctNoHp;

    @FindBy(xpath = "//span[@id='xemail']")
    private static WebElement expctEmail;



    public Soal11(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public String menuSoal11Validation(){
        return labelMenuSoal11==null?"":new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(labelMenuSoal11)).getText();
    }
    public void inputNamaDepan(String namaDepan){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(fieldNamaDepan)).sendKeys(namaDepan);
        }catch (Exception e){
            System.out.println("Komponen Text Field Username Tidak Ditemukan !!");
        }
    }
    public void inputNamaBelakang(String namaBelakang){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(fieldNamaBelakang)).sendKeys(namaBelakang);
        }catch (Exception e){
            System.out.println("Komponen Text Field Username Tidak Ditemukan !!");
        }
    }
    public void inputPassword(String password){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(fieldPassword)).sendKeys(password);
        }catch (Exception e){
            System.out.println("Komponen Text Field Username Tidak Ditemukan !!");
        }
    }
    public void inputAlamatLengkap(String alamatLengkap){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(fieldAlamat)).sendKeys(alamatLengkap);
        }catch (Exception e){
            System.out.println("Komponen Text Field Username Tidak Ditemukan !!");
        }
    }
    public void inputNoHP(String noHp){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(fieldNoHp)).sendKeys(noHp);
        }catch (Exception e){
            System.out.println("Komponen Text Field Username Tidak Ditemukan !!");
        }
    }
    public void inputEmail(String email){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(fieldEmail)).sendKeys(email);
        }catch (Exception e){
            System.out.println("Komponen Text Field Username Tidak Ditemukan !!");
        }
    }
    public void clickSubmit(){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(btnSubmit)).click();
        }catch (Exception e){
            System.out.println("Komponen Tombol Tidak Ditemukan !!");
        }
    }
    public static String validationND(){
        return expctNamaDepan==null?"":new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(expctNamaDepan)).getText();
    }
    public static String validationNB(){
        return expctNamaBelakang==null?"":new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(expctNamaBelakang)).getText();
    }
    public static String validationPass(){
        return expctPass==null?"":new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(expctPass)).getText();
    }
    public static String validationAlamat(){
        return expctAlamat==null?"":new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(expctAlamat)).getText();
    }
    public static String validationNoHp(){
        return expctNoHp==null?"":new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(expctNoHp)).getText();
    }
    public static String validationEmail(){
        return expctEmail==null?"":new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(expctEmail)).getText();
    }

}
