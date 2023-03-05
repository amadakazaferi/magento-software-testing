package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = { "pretty",
                "json:target/site/serenity/cucumber_reports/cucumber_report.json"},
        monochrome = true,
        tags = "",
        glue = {"utils.hooks","stepdefs"})
public class TestRunner {
}

