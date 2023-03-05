package utils.hooks;

import io.cucumber.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.magento.BasePage;

public class GlobalHooks {

    private static final Logger log = LoggerFactory.getLogger(GlobalHooks.class.getName());
    private BasePage basePage;
    @Before()
    public void before(){

    }
}
