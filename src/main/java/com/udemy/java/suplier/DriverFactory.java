package com.udemy.java.suplier;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.google.common.base.Supplier;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static final Supplier<WebDriver> chromeSupplier = () -> {
        /* System.setProperty("webdriver.chrome.driver", "C:/Drivers/Chrome/chrome"); */
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    };

    private static final Supplier<WebDriver> edgeSupplier = () -> {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    };

    /*
     * private static final Map<String, Supplier<WebDriver>> MAP = new HashMap<>();
     * 
     * static {
     * MAP.put("chrome", chromeSupplier);
     * MAP.put("edge", edgeSupplier);
     * }
     */

    //java 9 approach
    private static final Map<String, Supplier<WebDriver>> MAP = Map.of(
        "chrome", chromeSupplier,
        "edge", edgeSupplier
    );

    public static WebDriver getDriver(String browser) {
        return MAP.get(browser).get();
    }

}
