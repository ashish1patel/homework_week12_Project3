package testsuit;

import browserfacctory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter “tomsmith” username
        driver.findElement(By.xpath("//input[@type= 'text']")).sendKeys("tomsmith");

        //Enter “SuperSecretPassword!” password
        driver.findElement(By.xpath("//input[@type= 'password']")).sendKeys("SuperSecretPassword!");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[@class= 'fa fa-2x fa-sign-in']")).click();

        //Verify the text “Secure Area”
        String expectedTest = "Secure Area";
        String actualTest = driver.findElement(By.xpath("//h2[text()=' Secure Area']")).getText();
        Assert.assertEquals("Not directed to Login page", actualTest, expectedTest);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //Enter “tomsmith1” username
        driver.findElement(By.xpath("//input[@type= 'text']")).sendKeys("tomsmith1");

        // Enter “SuperSecretPassword” password
        driver.findElement(By.xpath("//input[@type= 'password']")).sendKeys("SuperSecretPassword!");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[@class= 'fa fa-2x fa-sign-in']")).click();

        //Verify the error message “Your username is invalid!”
        String expectedTest = "Your username is invalid!";
        String actualTest = driver.findElement(By.xpath("//div[@id = 'flash']")).getText();
        Assert.assertEquals("Not directed to Login page", expectedTest,actualTest);
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        //Enter “tomsmith” username
        driver.findElement(By.xpath("//input[@type= 'text']")).sendKeys("tomsmith");

        //  Enter “SuperSecretPassword” password
        driver.findElement(By.xpath("//input[@type= 'password']")).sendKeys("SuperSecretPassword");

        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[@class= 'fa fa-2x fa-sign-in']")).click();

        // Verify the error message “Your password is invalid!”
        String expectedTest = "Your password is invalid!";
        String actualTest = driver.findElement(By.xpath("//div[@class='flash error']")).getText();
        Assert.assertEquals("Not directed to Login page", actualTest, expectedTest);

    }

    @After
    public void tearDown() {
        //  closeBrowser();
    }
}
