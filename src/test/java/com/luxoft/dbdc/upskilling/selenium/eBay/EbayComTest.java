package com.luxoft.dbdc.upskilling.selenium.eBay;

import com.luxoft.dbdc.upskilling.selenium.eBay.pageobject.EbayComPageObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class EbayComTest {

        protected static WebDriver webDriver;
        EbayComPageObject ebayPage;

        @BeforeAll
        public static void setUp(){
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
            webDriver = new ChromeDriver();
        }

        @BeforeEach
        public void setUpForEach(){
            ebayPage  = new EbayComPageObject (webDriver);
        }

        @Test
        public void shouldShowBestPriceWhenSelectAuctionAfterEach () {
            ebayPage.goToMainPage()
                    .searchFor("leather bags")
                    .selectAuctionItems();
            assertThat (ebayPage.getAuctionBestPrices(),
                    containsInAnyOrder("Under $8.00")); //, "$8.00 - $18.00", "Over $18.00"));
        }

        @AfterAll
        public static void tearDown() {
            webDriver.quit();;
        }
}
