package utils.settings;

import java.io.*;
import java.util.Scanner;

public class MagentoSettings {

    public static final String testFirstName = "Test";
    public static final String testLastName = "User";
    public static final String testPassword = "userTest23.";

    public static final String baseMail = "test_user";
    public static String dynamicEmail = "";

    public static String lastDynamicEmail = "";
    public static final String testUsername = testFirstName.concat(testLastName);

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

}
