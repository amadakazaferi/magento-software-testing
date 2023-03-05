package pages.magento;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;

import static utils.settings.MagentoSettings.baseMail;
import static utils.settings.MagentoSettings.magentoBaseUrl;

public class BasePage extends PageObject {

    @FindBy(xpath = "//div[@class='panel header']//a[text()='Create an Account']")
    private WebElementFacade createAccountLink;

    @FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
    private WebElementFacade signInLink;

    public WebElementFacade getCreateAccountLink() { return createAccountLink; }
    public WebElementFacade getSignInLink() { return signInLink; }



    /* navigates to Magento HomePage */
    public void navigateToHome(){
        getDriver().navigate().to(magentoBaseUrl);
    }

    /**
    * @return An email is returned to be used to access FE
    */
    public String generateRandomEmailAddress(){
        String email = baseMail + new SimpleDateFormat("yyMMddHHmmss").format(new java.sql.Timestamp(System.currentTimeMillis())) + "@gmail.com";
        System.out.println("Email generated correctly: " + email);
        return email;
    }

}
