package com.luxoft.dbdc.upskilling.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SampleSileniumTest {
    private static WebDriver webDriver;

    @BeforeAll
    public static void setUp () {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions opt = new ChromeOptions();
        //opt.setHeadless(true);
        webDriver = new ChromeDriver(opt);
    }

    @Test
    public void googleComSimpleTest () throws InterruptedException {
        String address = "https://www.google.com.ua";
        String queryString = "selenium";
        webDriver.get(address);
        WebElement searchField = webDriver.findElement(By.name("q"));
        ((WebElement) searchField).sendKeys("selenium" + Keys.ENTER);
        Thread.sleep(3000);
        Assertions.assertTrue(webDriver.getTitle().contains(queryString));
    }

    @AfterAll
    public static void tearDown(){
        webDriver.quit();
    }
}
