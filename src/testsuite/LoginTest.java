package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {

    String BaseUrl = "https://courses.ultimateqa.com/";
    @Before

    public void setUp()
    {
        openBrowser(BaseUrl);
    }
    // Verifying user should be able to navigate to log in page
    @Test
        public void userShouldNavigateToLoginPageSuccessfully (){

        //clicking the sign in link
        clickOnElement(By.linkText("Sign In"));
        //sending email fields
        sendTextToElement(By.id("user[email]"),"prime@gmail.com");
        //sending password field
        sendTextToElement(By.name("user[password]"),"abcd123");
        //comparing the expected and actual results
        verifyElements("Messages does not match","Welcome Back!",By.xpath("//h1[contains(text(),'Welcome Back!')]"));
    }

    // Verifying the error message with invalid credentials
    @Test
    public void verifyTheErrorMessage() {

        clickOnElement(By.linkText("Sign In"));

        sendTextToElement(By.id("user[email]"),"abc@gmail.com");

        sendTextToElement(By.name("user[password]"),"abc123");

        clickOnElement(By.cssSelector("input[value='Sign in']"));

        verifyElements("Invalid email/password message not displayed","Invalid email or password.",By.xpath("//li[contains(text(),'Invalid email or password.')]"));
    }
    @After
    public void tearDown()
    {
      //closeBrowser();
    }
}
