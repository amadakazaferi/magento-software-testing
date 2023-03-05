package pages.magento;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@name='login[username]']")
    private WebElementFacade loginEmailInput;

    @FindBy(xpath = "//input[@name='login[password]']")
    private WebElementFacade loginPswInput;

    @FindBy(xpath = "//button[@class='action login primary']")
    private WebElementFacade loginButton;

    public WebElementFacade getLoginEmailInput() { return loginEmailInput; }

    public WebElementFacade getLoginPswInput() { return loginPswInput; }

    public WebElementFacade getLoginButton() { return loginButton; }
}
