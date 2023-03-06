package utils.hooks;

import io.cucumber.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.magento.BasePage;
import steps.MagentoUser;

import java.io.IOException;

import static utils.settings.MagentoSettings.magentoLoginUrl;

public class GlobalHooks {

    private static final Logger log = LoggerFactory.getLogger(GlobalHooks.class.getName());
    private BasePage basePage;
    private MagentoUser magentoUser;

    @Before(value = "@UserLoggedIn")
    public void before() throws IOException {
        basePage.navigateTo(magentoLoginUrl);
        magentoUser.loginWithDynamicEmail();
    }


}
