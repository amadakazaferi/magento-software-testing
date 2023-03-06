package stepdefs;

import io.cucumber.java.en.Given;
import pages.magento.BasePage;
import steps.MagentoUser;

public class WishlistSteps {

    private BasePage basePage;
    private MagentoUser magentoUser;

    @Given("user removes existing price filter")
    public void removePriceFilter(){
        magentoUser.removePriceFilter();
    }
}
