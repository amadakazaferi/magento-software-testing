package pages.magento;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage{

    @FindBy(xpath = "//h1[@class='page-title']//span")
    private WebElementFacade createAccountPageTitle;

    @FindBy(xpath = "//input[@name='firstname']")
    private WebElementFacade firstNameinput;

    @FindBy(xpath = "//input[@name='lastname']")
    private WebElementFacade lastNameinput;

    @FindBy(xpath = "//input[@id='email_address']")
    private WebElementFacade emailAddressInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElementFacade passwordInput;

    @FindBy(xpath = "//input[@id='password-confirmation']")
    private WebElementFacade confirmPasswordInput;

    @FindBy(xpath = "//button[@class='action submit primary']")
    private WebElementFacade createAccountButton;

    @FindBy(xpath = "//div[@class='messages' and @role = 'alert']")
    private WebElementFacade accountCreatedAlert;


    public WebElementFacade getCreateAccountPageTitle() { return createAccountPageTitle; }

    public WebElementFacade getFirstNameinput() { return firstNameinput; }

    public WebElementFacade getLastNameinput() { return lastNameinput; }

    public WebElementFacade getCreateAccountButton() { return createAccountButton;}

    public WebElementFacade getEmailAddressInput() { return emailAddressInput; }

    public WebElementFacade getPasswordInput() { return passwordInput; }

    public WebElementFacade getConfirmPasswordInput() { return confirmPasswordInput; }

    public WebElementFacade getAccountCreatedAlert() { return accountCreatedAlert; }
}
