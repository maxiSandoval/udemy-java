package com.udemy.java.test;

import java.util.function.Consumer;

import org.testng.Assert;

import com.udemy.java.assignment.PaymentDetailsPage;

public class PaymentDetailsActions {

    public static final Consumer<PaymentDetailsPage> freeCoupon = (p) -> p.applyCoupon("FREEUDEMY");
    public static final Consumer<PaymentDetailsPage> partialCoupon = (p) -> p.applyCoupon("PARTIALUDEMY");
    public static final Consumer<PaymentDetailsPage> validCC = (p) -> p.enterCC("4111111111111111", "2023", "123");
    public static final Consumer<PaymentDetailsPage> invalidCC = (p) -> p.enterCC("4111111111113333", "2023", "123");
    public static final Consumer<PaymentDetailsPage> buy = (p) -> p.buyBtnClick();

    // validations
    public static final Consumer<PaymentDetailsPage> successfulPurchase = (p) -> Assert.assertEquals(p.getStatus(), "PASS");;
    public static final Consumer<PaymentDetailsPage> failedPurchase = (p) -> Assert.assertEquals(p.getStatus(), "FAIL");;
}
