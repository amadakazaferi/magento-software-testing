package pages.magento;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishlistPage extends BasePage{

    @FindBy(xpath = "//div[@class='actions-secondary']//a[@class='btn-remove action delete']")
    private WebElementFacade removeItem;

    @FindBy(xpath = "//ol[@id='wishlist-sidebar']//li")
    private List<WebElementFacade> wishlistItems;

    @FindBy(xpath = "//div[@class='block-title']//strong[text()='My Wish List']//following-sibling::span[@class='counter']")
    private WebElementFacade wishlistCounter;

    @FindBy(xpath = "//div[@class='page messages']//div[@role='alert']")
    private WebElementFacade messagesList;

    public WebElementFacade getRemoveItem() {
        return removeItem;
    }

    public List<WebElementFacade> getWishlistItems() {
        return wishlistItems;
    }

    public WebElementFacade getWishlistCounter() {
        return wishlistCounter;
    }

    public WebElementFacade getMessagesList() {
        return messagesList;
    }
}
