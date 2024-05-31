package com.juaracoding.aihujian4.ujian4.util;

import com.juaracoding.aihujian4.ujian4.connection.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

public class GlobalFunction {



    public static void dropDownlist(WebDriver driver, String strXpath){
        List<WebElement> d =driver.findElements(By.xpath(strXpath));
        Iterator<WebElement> itr = d.iterator();

        int intIter = 1;
        String value = "";
        while (itr.hasNext()){
            WebElement element = itr.next();
            value = element.getText();
            System.out.println("Element get Text : "+value);
        }
    }

    /** ini untuk konfigurasi di seluruh step */
    public static  void delay(int intDetik){
        if(Constants.GLOB_PARAM_DELAY.equalsIgnoreCase("y")){
            try {
                Thread.sleep(intDetik*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /** ini untuk proses Asyncronous */
    public static  void delay(int intDetik,String strNull){
        try {
            Thread.sleep(intDetik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
