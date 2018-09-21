package com.luxoft.dbdc.upskilling.selenium.eBay.pageobject;


import com.luxoft.dbdc.upskilling.selenium.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class EbayComPageObject extends BasePageObject {

    private final String SEARCH_FIELD = "#gh-ac";
    private final String AUCTION_BUTTON = "a[title='Auction']";
//    @FindBy (id="gh-ac")
//    private WebElement searchFieldElement;

    private final String mainAddress = "https://www.ebay.com";
    private final String SHOP_BY_PRICE_ITEMS = "a.search-guidance__text-item-link";

    public EbayComPageObject (WebDriver webDriver) {
        super (webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public EbayComPageObject goToMainPage () {
        webdriver.get(mainAddress);
        return this;
    }
    public EbayComPageObject searchFor (String item) {
        enterCriteriaToSearchFild(item);
        return this;
    }

    private void enterCriteriaToSearchFild (String item) {
        WebElement  searchField = getSearchField();
       // WebElement searchField = searchFieldElement;
        searchField.clear();
        searchField.sendKeys((item + Keys.ENTER));
       // searchField.submit();
    }

    private WebElement getSearchField(){
        return findElemenWithWait(By.cssSelector(SEARCH_FIELD));
    }

    public EbayComPageObject selectAuctionItems () {
        findElemenWithWait(By.cssSelector(AUCTION_BUTTON)).click();

        //  or
//        String auctionItemButton = String.format("button[title='%s']", "Auction");
//        findElemenWithWait(By.cssSelector(auctionItemButton));
        return this;
    }

    public List<String> getAuctionBestPrices () {
       return webdriver.findElements(By.cssSelector("SHOP_BY_PRICE_ITEMS"))
               .stream().map(webElement -> webElement.getText())
               .peek(System.out::println)
               .collect(Collectors.toList());

    }
}
