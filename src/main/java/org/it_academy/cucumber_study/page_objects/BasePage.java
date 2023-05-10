package org.it_academy.cucumber_study.page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    public static boolean isElementVisible(SelenideElement locator) {
        return $(locator).shouldBe(Condition.appear).is(Condition.visible);
    }

}
