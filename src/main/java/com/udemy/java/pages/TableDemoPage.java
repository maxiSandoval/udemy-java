package com.udemy.java.pages;

import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TableDemoPage {

    @FindBy(xpath = "//tr")
    private List<WebElement> tableRow;

    private final WebDriver driver;

    public TableDemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html");
    }


    public void selectRows(Predicate<List<WebElement>> predicate){
        tableRow.stream()
                .skip(1)
                .map(trList -> trList.findElements(By.tagName("td")))
                .filter(tdList -> tdList.size() == 4) // validate empty td
                .filter(predicate)
                .map(tdList -> tdList.get(3))
                .map(td -> td.findElement(By.tagName("input")))
                .forEach(WebElement::click);
    }


}
