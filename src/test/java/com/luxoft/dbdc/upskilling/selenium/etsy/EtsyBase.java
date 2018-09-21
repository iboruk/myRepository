package com.luxoft.dbdc.upskilling.selenium.etsy;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EtsyBase {
    protected static WebDriver webDriver;

    @BeforeAll
    public static void setUp () {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions opt = new ChromeOptions();
        //opt.setHeadless(true);
        webDriver = new ChromeDriver(opt);
        webDriver.manage().deleteAllCookies();
    }

    @AfterAll
    public static void tearDown(){
        webDriver.quit();
    }
}
