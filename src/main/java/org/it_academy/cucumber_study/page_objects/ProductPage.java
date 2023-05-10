package org.it_academy.cucumber_study.page_objects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage extends BasePage {
    private final SelenideElement PRODUCT_TITTLE = $(By
            .xpath("//div[@class=\"catalog-masthead\"]"));

    private final SelenideElement BUY_BUTTON = $(By
            .xpath("//a[contains(@class, 'button_buy')]"));

    private final SelenideElement PRODUCT_IS_ADDED_SUBHEADER = $(By
            .xpath("//div[@class=\"product-recommended__subheader\"]"));

    private final SelenideElement CHECKOUT_TITTLE = $(By
            .xpath("//div[contains(@class, 'cart-form__title cart-form__title_big-alter')]"));

    public String getAddedToCartSubheaderText(){
        return PRODUCT_IS_ADDED_SUBHEADER.getText();
    }

    public ProductPage clickOnBuyButton() {
        BUY_BUTTON.click();
        return this;
    }

    public boolean isCheckOutVisible() {
        return isElementVisible(CHECKOUT_TITTLE);
    }

    public String getProductTittleText() {
        return PRODUCT_TITTLE.getText();
    }
}
