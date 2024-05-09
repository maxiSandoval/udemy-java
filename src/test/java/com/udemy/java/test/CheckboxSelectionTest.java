package com.udemy.java.test;

import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    private TableDemoPage tdPage;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
        this.tdPage = new TableDemoPage(driver);
    }

    @Test(dataProvider = "criteriaProvider")
    public void tableRowTest(Predicate<List<WebElement>> searchCriteria) {
        tdPage.goTo();
        tdPage.selectRows(searchCriteria);
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }

    @DataProvider(name = "criteriaProvider")
    public Object[] testdata() {
        return new Object[] {
            SearchCriteriaFactory.getCriteria("allMale"),
            SearchCriteriaFactory.getCriteria("allFemale"),
            SearchCriteriaFactory.getCriteria("allGender"),
            SearchCriteriaFactory.getCriteria("allAU"),
            SearchCriteriaFactory.getCriteria("allFemaleAU")
        };
    }

}
