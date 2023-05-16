package org.it_academy.cucumber_study.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.it_academy.cucumber_study.driver.Driver;
import org.it_academy.cucumber_study.page_objects.MainPageOnliner;
import org.it_academy.cucumber_study.page_objects.ProductPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchAndAddToCartSteps {

    private final MainPageOnliner mainPageOnliner = new MainPageOnliner();

    private final ProductPage productPage = new ProductPage();

    private String requestTittle;

    @Given("the user opens Onliner site")
    public void theUserOpensOnlinerSite() {
        Driver.initDriver();
        mainPageOnliner.openSite();
    }

    @When("user clicks on search bar and input {string} request")
    public void userClicksOnSearchBarAndInputRequest(String request) {
        mainPageOnliner.search(request);
    }


    @And("search results are appeared on the screen")
    public void searchResultsAreAppearedOnTheScreen() {
        assertThat(mainPageOnliner
                .iFrameCheck())
                .as("Trouble msg")
                .isTrue();
    }

    @Then("user clicks on first result link")
    public void userClicksOnFirstResultLink() {
        mainPageOnliner
                .switchToiFrame();
        requestTittle = mainPageOnliner.getProductName();
        mainPageOnliner
                .clickOnProductLink();
    }

    @And("product page is opened")
    public void productPageIsOpened() {
        assertThat(productPage
                .getProductTittleText())
                .contains(requestTittle);
    }

    @Then("user clicks on first buy button")
    public void userClicksOnFirstBuyButton() {
        productPage.clickOnBuyButton();
    }

    @Then("cart is opened")
    public void cartIsOpened() {
        productPage.isCheckOutVisible();
    }

    @Then("product in the cart is same to added one")
    public void productInTheCartIsSameToAddedOne() {
        System.out.println(productPage.getProductNameInCart() + "sdfjhgioasfghiupsdfsdopfhnoisdfhg");
        assertThat(requestTittle.contains(productPage.getProductNameInCart())).isTrue();
    }
}
