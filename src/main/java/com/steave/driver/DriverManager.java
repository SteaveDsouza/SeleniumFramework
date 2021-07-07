package com.steave.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	public static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return dr.get();
	}

	public static void setDriver(WebDriver driver) {
		if (Objects.nonNull(driver)) {
			dr.set(driver);
		}
	}

	public static void unload() {
		dr.remove();
	}
}
