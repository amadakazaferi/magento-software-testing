package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.MagentoUser;

public class ShoppingCartSteps {

private MagentoUser magentoUser;
    @Given("user opens Shopping Cart")
    public void openShoppingCart(){

    }

    @When("user adds all displayed items in Shopping Cart")
    public void userAddsAllDisplayedItemsInShoppingCart() {
    }

    @Then("items are successfully added")
    public void itemsAreSuccessfullyAdded() {
    }

    @Then("the user is in Shopping Cart Page")
    public void theUserIsInShoppingCartPage() {
    }

    @And("sum of all items price equals Total price")
    public void sumOfAllItemsPriceEqualsTotalPrice() {
    }

    @When("user deletes {string} item from shopping cart")
    public void userDeletesItemFromShoppingCart(String arg0) {
    }

    @Then("the number of items is decreased by {string} item")
    public void theNumberOfItemsIsDecreasedByItem(String arg0) {
    }
}
