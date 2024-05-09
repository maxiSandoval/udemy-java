package com.udemy.java.test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.java.suplier.DriverFactory;

public class HoverableDropdown {

    private WebDriver driver;
    private Actions actions;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("edge") String browser) {
        this.driver = DriverFactory.getDriver(browser);
        this.actions = new Actions(driver);
    }

    @Test(dataProvider = "linkProvider")
    public void hoverableTest(String path) {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/drop-down.html");
        List<String> split = Arrays.asList(path.split(" => "));
       // String[] split2 = path.split(" => ");

        // Arrays.stream(split2)
        split.stream()
                .map(s -> this.driver.findElement(By.xpath("//a[contains(text(), '" + s + "')]")))
                .map(ele -> actions.moveToElement(ele))
                .forEach(a -> a.perform());

        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }

    @DataProvider(name = "linkProvider")
    public Object[] testdata() {
        return new Object[] {
                "Dropdown => Dropdown Link 5",
                "Dropdown => Dropdown Link 5 => Dropdown Submenu Link 5.1",
                "Dropdown => Dropdown Link 5 => Dropdown Submenu Link 5.4 => Dropdown Submenu Link 5.4.1",
        };
    }
}
