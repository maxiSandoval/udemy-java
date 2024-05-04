package com.udemy.java.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.udemy.java.pages.TableDemoPage;
import com.udemy.java.suplier.DriverFactory;

public class CheckboxSelectionTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
    }

    @Test(dataProvider = "criteriaProvider")
    public void tableRowTest(String gender) {
        TableDemoPage tdPage = new TableDemoPage(driver);
        tdPage.goTo();
        tdPage.checkBoxes(gender);
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }

    @DataProvider(name = "criteriaProvider")
    public Object[] testdata() {
        return new Object[] {
                "male",
                "female"
        };
    }

}
