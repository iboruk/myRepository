package com.luxoft.dbdc.upskilling.selenium.etsy;



import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.openqa.selenium.By.cssSelector;

public class EtsyComEmptyCard extends EtsyBase {

    private static final String PRIVACY_POLICY_ACCEPT_BUTTON = "button.btn-outline";
    private static final String PRIVACY_POLICY_FORM = ".alert";
    private static final String SHOPPING_CART_ICON = ".etsy-icon-cart";
    private static final String PRIVACY_POLICY_SUCCESS_MODAL = ".alert-success";
    private static final String EMTY_CARD_HEADER = "div.empty-header";

    @Test
    public void shouldHaveEmptySoppingCartOnFirstVisit() throws InterruptedException {
        // Go to etsy.com.page
        String mainPage = "http://www.etsy.com";
        webDriver.
                get(mainPage);
        //Accept privacy rules
        WebElement acceptPrivacyRulesButton =
                webDriver.findElement(cssSelector(PRIVACY_POLICY_FORM))
                        .findElement(cssSelector(PRIVACY_POLICY_ACCEPT_BUTTON));
        acceptPrivacyRulesButton.click();
        // Go to Cart
        WebElement shoppingCartIcon =
                webDriver.findElement(cssSelector(SHOPPING_CART_ICON));
        shoppingCartIcon.click();
        new WebDriverWait(webDriver, 200).until(
                webDriver1 -> webDriver1.findElement(By.cssSelector(PRIVACY_POLICY_SUCCESS_MODAL)));
        //Thread.sleep(2000);
        webDriver.get(mainPage + "/cart");
        // Check if card is empty
        boolean ShoppingCartHasNoItems = webDriver.findElement(By.cssSelector(EMTY_CARD_HEADER)).isDisplayed();
        assertThat(ShoppingCartHasNoItems, is(true));
    }
}
