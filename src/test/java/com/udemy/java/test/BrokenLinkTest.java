package com.udemy.java.test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.udemy.java.suplier.DriverFactory;
import com.udemy.java.util.LinkUtil;

public class BrokenLinkTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("edge") String browser) {
        this.driver = DriverFactory.getDriver(browser);
    }

    @Test
    public void linkTest() {
        // this.driver.get("https://the-internet.herokuapp.com/broken_images");
        // this.driver.findElements(By.xpath("//*[@href]"))
        /*
         * boolean result = this.driver.findElements(By.xpath("//*[@src]"))
         * .stream()
         * // .map(e -> e.getAttribute("href"))
         * .map(e -> e.getAttribute("src"))
         * .map(src -> LinkUtil.getResponseCode(src))
         * // .forEach(src -> System.out.println(LinkUtil.getResponseCode(src) + " :: "
         * + src));
         * .anyMatch(rc -> rc != 200);
         * 
         * Assert.assertFalse(result);
         */

        /*
         * List<String> list = this.driver.findElements(By.xpath("//*[@src]"))
         * .stream()
         * .map(e -> e.getAttribute("src"))
         * .filter(src -> LinkUtil.getResponseCode(src) != 200)
         * .collect(Collectors.toList());
         * 
         * Assert.assertEquals(list.size(), 0, list.toString());
         */

        this.driver.get("https://google.com");
        System.out.println("Before :: " + LocalDateTime.now());
        List<String> list = this.driver.findElements(By.xpath("//*[@href]"))
                .stream()
                .parallel() // improve the performance
                .map(e -> e.getAttribute("href"))
                .filter(src -> LinkUtil.getResponseCode(src) != 200)
                .collect(Collectors.toList());

        System.out.println("After :: " + LocalDateTime.now());
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }

}
