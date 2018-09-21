package com.luxoft.dbdc.upskilling.selenium.eBay;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class EbayComCart extends EbayBase {

    //private static final String ID_SHOPPING_CART_ICON = "gh-cart-i";
    private static final String ID_SHOPPING_CART_ICON = "#gh-cart-i";
    private static final String XPATH_SHOPPING_CART_ICON = "//*[@id=\'gh-cart-i\']";
    private static final String EMPTY_CART = "You don't have any items in your cart.";


    @Test
    public void openEbaySite() throws InterruptedException {
        String mainPage = "https://www.ebay.com/";
        // Go to eBay
        webDriver.get(mainPage);
        webDriver.manage().window().maximize();
    }

    @Test
    public void goToCart () throws InterruptedException {
        openEbaySite();
        //
        //WebElement shoppingCartIcon =  webDriver.findElement(By.id(ID_SHOPPING_CART_ICON));
//        WebElement shoppingCartIcon = webDriver.findElement(By.xpath(XPATH_SHOPPING_CART_ICON));

        WebElement shoppingCartIcon = webDriver.findElement(By.cssSelector(ID_SHOPPING_CART_ICON));
        shoppingCartIcon.click();
        Thread.sleep(2000);
        boolean ShoppingCartHasNoItems = webDriver.
                findElement(By.xpath("//*[@id='mainContent']/div/div[2]/div/div/div[1]")).isDisplayed();
        assertThat(ShoppingCartHasNoItems, is(true));
        // "//*[@id='mainContent']/div/div[2]/div/div/div[1]" xpath for field with sign Empty

    }
}
