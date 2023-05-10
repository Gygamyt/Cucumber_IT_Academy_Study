package org.it_academy.cucumber_study.page_objects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MainPageOnliner extends BasePage {

    private final SelenideElement SEARCH_FIELD = $(By.xpath("//input[@class=\"fast-search__input\"]"));

    private final SelenideElement PRODUCT_NAME_XPATH = $(By
            .xpath("//div[@class=\"product__title\"]/a[@target=\"_parent\"]"));

    private final SelenideElement IFRAME_XPATH = $(By.xpath("//iframe[@class=\"modal-iframe\"]"));

    public MainPageOnliner search(String request) {
        $(SEARCH_FIELD).sendKeys(request);
        return this;
    }

    public void openSite() {
        open("https://www.onliner.by/");
    }
    public boolean iFrameCheck() {
        return isElementVisible(IFRAME_XPATH);
    }

    public String getProductName() {
        return $(PRODUCT_NAME_XPATH).getText();
    }

    public ProductPage clickOnProductLink() {
        $(PRODUCT_NAME_XPATH).click();
        return new ProductPage();
    }

    public MainPageOnliner switchToiFrame() {
        switchTo().frame($(IFRAME_XPATH));
        return this;
    }
}
