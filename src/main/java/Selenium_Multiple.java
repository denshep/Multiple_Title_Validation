import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


/**
 * Created by ds on 2/5/15.
 */
public class Selenium_Multiple {
    public static void main(String[] args) {

        if (args.length == 0){
            System.err.println("No arguments!");
            System.exit(1);
        }


        WebDriver driver = new FirefoxDriver(); // Version 1.? :: Firefox
        for (int i = 0; i < args.length; i++) {

            String test_case_id = "TC-001.0" + (i+1);
            String param[] = args[i].split("\\|");
            String url = param[0];
            String title_expected = param[1];

            driver.get(url);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            String title_actual = driver.getTitle();

            if (title_expected.equals(title_actual)) {
                System.out.println("Test Case ID: \t\t" + test_case_id);
                System.out.println("URL: \t\t" + url);
                System.out.println("Title Expected: \t\t" + title_expected);
                System.out.println("Test Case Result: \t\t" + "PASSED");
            } else {
                System.out.println("Test Case ID: \t\t" + test_case_id);
                System.out.println("URL: \t\t" + url);
                System.out.println("Title Expected: \t\t" + title_expected);
                System.out.println("Test Case Result: \t\t" + "FAILED");
            }
        }
        driver.quit();
    }
}