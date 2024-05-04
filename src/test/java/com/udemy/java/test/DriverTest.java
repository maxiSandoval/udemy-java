package com.udemy.java.test;

import java.util.List;

import javax.lang.model.util.Elements;
import javax.swing.text.html.parser.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.udemy.java.pages.TableDemoPage;
import com.udemy.java.predicate.Rules;
import com.udemy.java.suplier.DriverFactory;

public class DriverTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("edge") String browser) {
        this.driver = DriverFactory.getDriver(browser);
    }

    // (1st stream assinment) not allow blnak links and that contains s
    // convert link text to uppercase and then print on the console

    @Test
    public void googleTest() {
        this.driver.get("https://google.com/");
        //List<WebElement> elements = 
        this.driver.findElements(By.tagName("a"))
                                            .stream()
                                            .map(WebElement::getText)
                                            .map(String::trim)
                                            .filter(e -> e.length() > 0)
                                            .filter(e -> !e.toLowerCase().contains("s"))
                                            .map(String::toUpperCase)
                                            .forEach(System.out::println);
                                          
        // .forEach(e -> System.out.println(e.getText()));
        /*
         * // remove blanks and 's' with Predicate, it changes to Rule class
         * System.out.println("Before:: " + elements.size());
         * // chain with 'or'
         * // elements.removeIf(isBlank.or(hasS));
         * //Rules.get().forEach((rule) -> elements.removeIf(rule));
         * Rules.get().forEach(elements::removeIf);
         * System.out.println("After:: " + elements.size());
         * System.out.println("Not contain S:: ");
         * elements.forEach(e -> System.out.println(e.getText()));
         */

    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }

}
