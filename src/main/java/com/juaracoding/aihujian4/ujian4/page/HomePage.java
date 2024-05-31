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

import com.juaracoding.aihujian4.ujian4.connection.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private static WebDriver driver;

    @FindBy(xpath = "//a[normalize-space()='Soal-1.1']")
    private WebElement btnMenuSoal11;

    @FindBy(xpath = "//h2[normalize-space()='4 Fitur Unggulan']")
    private WebElement homepageLogo;

    @FindBy(xpath = "//a[normalize-space()='logout']")
    private static WebElement btnLogout;

    public HomePage() {
        this.driver= DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    public HomePage(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public String homePageValidation(){
        return homepageLogo==null?"4 Fitur Unggulan":homepageLogo.getText();
    }

    public static WebElement logout(){

        return btnLogout;
    }
    public WebElement goToMenuSoal11(){
        return btnMenuSoal11;
    }
}
