package com.juaracoding.aihujian4.ujian4.connection.driver;

import com.juaracoding.aihujian4.ujian4.connection.DriverStrategy;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy {

	@Override
	public WebDriver setStrategy() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
}
