package com.udemy.java.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.udemy.java.assignment.PaymentDetailsPage;
import com.udemy.java.suplier.DriverFactory;

import static com.udemy.java.test.PaymentDetailsActions.*;

import java.util.function.Consumer;

public class PaymentDetailsTest {

    private WebDriver driver;
    PaymentDetailsPage paymentDetailsPage;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
        this.paymentDetailsPage = new PaymentDetailsPage(driver);
    }

    @Test(dataProvider = "cases")
    public void paymentDetailsTest(Consumer<PaymentDetailsPage> consumer) {
        this.paymentDetailsPage.goTo();
        consumer.accept(paymentDetailsPage);
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }

    @DataProvider(name = "cases")
    public Object[] testdata() {
        return new Object[] {
            freeCoupon.andThen(buy).andThen(successfulPurchase),
            validCC.andThen(buy).andThen(successfulPurchase),
            partialCoupon.andThen(validCC).andThen(buy).andThen(successfulPurchase),
            partialCoupon.andThen(invalidCC).andThen(buy).andThen(failedPurchase),
            invalidCC.andThen(buy).andThen(failedPurchase),
            buy.andThen(failedPurchase)
        };
    }
}
