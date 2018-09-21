package com.luxoft.dbdc.upskilling.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {
    protected WebDriver webdriver;
    private final int MAX_WAIT_TIME = 30;

    public BasePageObject(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    protected WebElement findElemenWithWait(By locator) {
//        WebDriverWait wait = new WebDriverWait(webdriver, MAX_WAIT_TIME);
//        return wait.untill
        return new WebDriverWait(webdriver, MAX_WAIT_TIME).until(
       // ExpectedConditions.visibilityOfElementLocated(locator));
        ExpectedConditions.presenceOfElementLocated(locator));
    }


}
