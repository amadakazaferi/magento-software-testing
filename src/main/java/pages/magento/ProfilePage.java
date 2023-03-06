package pages.magento;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{

    @FindBy(xpath = "//div[@class='panel header']//div[@class='customer-menu']//a[contains(text(),'Sign Out')]")
    private WebElementFacade logoutButton;

    @FindBy(xpath = "//div[@class='panel header']//button[@data-action='customer-menu-toggle']")
    private WebElementFacade menuToggle;

    public WebElementFacade getMenuToggle() { return menuToggle; }

    public WebElementFacade getLogoutButton() { return logoutButton; }
}
