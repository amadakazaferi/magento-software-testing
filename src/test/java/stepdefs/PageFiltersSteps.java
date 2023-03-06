package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.By;
import pages.magento.BasePage;
import pages.magento.StorePage;
import steps.MagentoUser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageFiltersSteps {

  @Steps(shared = true)
  private MagentoUser magentoUser;

    private BasePage basePage;

    private StorePage storePage;

    @Given("the user selects filters from the store menu")
    public void checkFilters(List<List<String>> dataTable) {
        magentoUser.checkPageFilters(dataTable);
    }

    @When("user selects {string} color in Shopping Options panel")
    public void selectItemColor(String colorName) {
        magentoUser.selectColor(colorName);
    }

    @Then("all the displayed products have the selected {string} bordered in red")
    public void viewDisplayedProductsInRed(String colorName) {
        List<WebElementFacade> list = storePage.getItemsList();
        for (WebElementFacade item : list) {
            boolean colorElement = item.containsElements(By.xpath("//div[contains(@class,'product details')]//div[@aria-label='" + colorName + "']"));
            assertTrue(colorElement);
        }

    }

    @When("user selects price {string}")
    public void userSelectsPrice(String priceRange) {
        magentoUser.selectPriceRange(priceRange);
    }

    @Then("products displayed match the price {string} criteria")
    public void productsDisplayedMatchThePriceCriteria(String priceRange) {
        System.out.println(priceRange);
        String[] prices = priceRange.split("-");
        String actualPrice = storePage.getPriceValuePDP().getText().replace("$", "");

    }

    @When("user click on Sort menu and selects {string}")
    public void sortFilters(String option) {
       magentoUser.sortFilters(option);
    }

    @Then("the products are sorted in ascending and descending direction")
    public void theProductsAreSortedInAscendingAndDescendingDirection() {

    }
}
