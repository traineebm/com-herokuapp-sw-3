package testsuite;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://the-internet.herokuapp.com/login";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        // Finding the username field element
        sendTextToElement(By.id("username"),"tomsmith" );
        // Finding the password field element
        sendTextToElement(By.id("password"),"SuperSecretPassword!");
        // Finding the login button and clicking on it
        clickOnElement(By.xpath("//button[@class='radius']"));

        //Validate expected and actual text message
        verifyElements("Login successful","Secure Area",By.xpath("//body[1]/div[2]/div[1]/div[1]/h2[1]"));

    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        // Finding the username field element
        sendTextToElement(By.id("username"),"tomsmith1");
        // Finding the password field element
        sendTextToElement(By.id("password"),"SuperSecretPassword!");
        // Finding the login button and clicking on it
        clickOnElement(By.xpath("//button[@class='radius']"));

        //Verify the text from the given requirements
        String expectedTextMessage = "Your username is invalid!";
        //Getting the text by using get method
        String actualTextMessage = getTextFromElement(By.id("flash"));
        //Using substring method
        String actualString = actualTextMessage.substring(0,25);
        //Validate expected and actual text message
        Assert.assertEquals("Login unsuccessful",expectedTextMessage,actualString);
    }
    @Test
    public void verifyThePasswordErrorMessage(){
        // Finding the username field element
        sendTextToElement(By.id("username"),"tomsmith");

        // Finding the password field element
        sendTextToElement(By.id("password"),"SuperSecretPassword");

        // Finding the login button and clicking on it
        clickOnElement(By.xpath("//button[@class='radius']"));

        //Verify the text from the given requirements
        String expectedTextMessage = "Your password is invalid!";
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//div[@id='flash']"));
        //Getting the text by using get method
        String actualTextMessage = actualTextMessageElement.getText();
        //Using substring method
        String actualString = actualTextMessage.substring(0,25);
        //Validate expected and actual text message
        Assert.assertEquals("Login unsuccessful", expectedTextMessage,actualString);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
