package com.udemy.java.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.udemy.java.assignment.PriceTablePage;
import com.udemy.java.suplier.DriverFactory;

public class PriceTableTest {

    private WebDriver driver;
    PriceTablePage priceTablePage;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("edge") String browser) {
        this.driver = DriverFactory.getDriver(browser);
        this.priceTablePage = new PriceTablePage(driver);
    }

    @Test
    public void minPriceTableTest() {
        this.priceTablePage.goTo();
        this.priceTablePage.selectMinPrice();
        this.priceTablePage.verifyClick();
        String status = this.priceTablePage.getStatus();
        
        Assert.assertEquals(status, "PASS");

    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}
