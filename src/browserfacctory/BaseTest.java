package browserfacctory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static String baseUrl = "http://the-internet.herokuapp.com/login";

    public void openBrowser(String baseUrl) {
        // launch Chrome browser
        driver = new ChromeDriver();
        // open the Url into web browser
        driver.get(baseUrl);
        // maximize the window
        driver.manage().window().maximize();
        // we give explicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    public void closeBrowser() {
        //close the browser
        driver.quit();
    }
}