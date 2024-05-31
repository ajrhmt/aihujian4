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
import org.testng.TestNG;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RunnerUjian {
    private static String namaDepan = "Aji";
    private static String namaBealakng = "Rohimat";
    private static String passWord = "ajrhmt03";
    private static String alaMat = "Kebon Kacang, Jakarta Pusat";
    private static String noHp = "85795599786";
    private static String email = "aji.rohimat";

    private String Browser = Constants.CHROME;


    public String getBrowser() {
        return Browser;
    }
    public String getNamaDepan() {
        return namaDepan;
    }
    public String getNamaBelakang() {
        return namaBealakng;
    }
    public String getPassWord() {
        return passWord;
    }
    public String getAlaMat() {
        return alaMat;
    }
    public String getNoHp() {
        return noHp;
    }
    public String getEmail() {
        return email;
    }
    public static void main(String[] args) {
        String rootProject = System.getProperty("user.dir");
        TestNG runner = new TestNG();
        runner.setOutputDirectory(rootProject+"\\output-testng\\selenium\\"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy-HHmmss")));
        List<String> suitefiles = new ArrayList<String>();
        suitefiles.add(rootProject+"\\ujianloginpositif.xml");
        suitefiles.add(rootProject+"\\ujianloginnegatif.xml");
        suitefiles.add(rootProject+"\\ujiansoal11.xml");
        runner.setTestSuites(suitefiles);
        runner.run();
    }
}
