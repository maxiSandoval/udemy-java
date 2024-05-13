package com.udemy.java.assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentDetailsPage {

    @FindBy(id = "coupon")
    private WebElement couponInput;

    @FindBy(id = "couponbtn")
    private WebElement couponBtn;

    @FindBy(id = "cc")
    private WebElement ccInput;

    @FindBy(id = "year")
    private WebElement yearInput;

    @FindBy(id = "cvv")
    private WebElement cvvInput;

    @FindBy(id = "buy")
    private WebElement buyBtn;

    @FindBy(id = "status")
    private WebElement statusText;

    private WebDriver driver;

    public PaymentDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-payment-screen.html");
    }

    public void applyCoupon(String coupon){
        this.couponInput.sendKeys(coupon);
        this.couponBtn.click();
    }

    public void enterCC(String cc, String year, String cvv){
        this.ccInput.sendKeys(cc);
        this.yearInput.sendKeys(year);
        this.cvvInput.sendKeys(cvv);
    }

    public void buyBtnClick(){
        this.buyBtn.click();
    }

    public String getStatus(){
        return statusText.getText().trim();
    }

}
