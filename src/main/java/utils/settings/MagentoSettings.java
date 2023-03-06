package utils.settings;

import com.ibm.icu.impl.Assert;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;

public class MagentoSettings {
private static final WebDriver driver= ThucydidesWebDriverSupport.getDriver();
    public static final String testFirstName = "Test";
    public static final String testLastName = "User";
    public static final String testPassword = "userTest23.";

    public static String simpleEmail = "test_user060323@gmail.com";
    public static final String baseMail = "test_user";
    public static String dynamicEmail = "";
    public static String lastDynamicEmail = "";
    public static final String testUsername = testFirstName.concat(" " + testLastName);
    public static final String magentoBaseUrl = "https://magento.softwaretestingboard.com/";
    public static final String magentoLoginUrl = magentoBaseUrl + "/customer/account/login/";


    public static void writeStrToFile(String email) throws IOException {
        FileWriter fileWriter = new FileWriter("src/main/resources/outputFile/lastDynamicEmail.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.printf(email);
        printWriter.close();
    }

    public static String readStrFromFile() throws IOException {
        BufferedReader reader =  new BufferedReader(new FileReader("src/main/resources/outputFile/lastDynamicEmail.txt"));
        String line;
        String lastLine = "";

        while ((line = reader.readLine()) != null)
        {
            lastLine = line;
        }
        return lastLine;
    }

    public static void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
}
