package pages.magento;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage{

@FindBy(xpath = "//div[contains(@id,'option-label-size-') and text()='XS']")
    private WebElementFacade size;

@FindBy(xpath = "//form[@data-role='tocart-form']//button[@title='Add to Cart' ]")
    private WebElementFacade addToCartButton;

@FindBy(xpath = "//div[@data-ui-id='message-success']//a[text()='shopping cart']")
private WebElementFacade openShoppingCartLink;

@FindBy(xpath = "//div[@data-ui-id='message-success']")
private WebElementFacade messageSuccess;

@FindBy(xpath = "//tbody[@class='cart item']//td[@data-th='Subtotal']//span//span//span")
private WebElementFacade priceValue;

@FindBy(xpath = "//tbody[@class='cart item']")
private List<WebElementFacade> cartItemsList;

@FindBy(xpath = "//td[@data-th='Order Total']//span")
private WebElementFacade totalPrice;


    public WebElementFacade getSize() {
        return size;
    }

    public WebElementFacade getAddToCartButton() {
        return addToCartButton;
    }

    public WebElementFacade getOpenShoppingCartLink() {
        return openShoppingCartLink;
    }

    public WebElementFacade getMessageSuccess() {
        return messageSuccess;
    }

    public WebElementFacade getPriceValue() {
        return priceValue;
    }

    public List<WebElementFacade> getCartItemsList() {
        return cartItemsList;
    }

    public WebElementFacade getTotalPrice() {
        return totalPrice;
    }
}
