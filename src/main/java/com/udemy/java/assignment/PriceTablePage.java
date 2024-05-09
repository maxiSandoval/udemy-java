package com.udemy.java.assignment;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PriceTablePage {

    @FindBy(id = "prods")
    private WebElement priceTable;

    @FindBy(id = "result")
    private WebElement verifyBtn;

    @FindBy(id = "status")
    private WebElement status;

    private WebDriver driver;

    public PriceTablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-price.html");
    }

    public void selectMinPrice() {
        Optional<List<WebElement>> min = priceTable.findElements(By.tagName("tr")).stream()
                .skip(1)
                .map(trList -> trList.findElements(By.tagName("td")))
                .filter(tdList -> tdList.size() == 4)
                .min(Comparator.comparing(tdList -> Integer.parseInt(tdList.get(2).getText())));
       
        min.ifPresent(l -> {
            min.get().get(3).findElement(By.tagName("input")).click();
        });
    }

    public void verifyClick(){
        this.verifyBtn.click();
    }

    public String getStatus(){
        return this.status.getText().trim();
    }
}
