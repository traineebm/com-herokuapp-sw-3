package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    /**
     * This method will click on element
     */
    public void clickOnElement(By by){
        WebElement element = driver.findElement(by);
        element.click();
    }

    /**
     * This method will get text from element
     */

    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    /**
     * This method will send text to element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
//************************ Alert methods********************************************//
    /**
     * This method will switch to alert
     */
    public void switchToAlert(){
        driver.switchTo().alert();
    }
    /**
     * This method will accept the alert
     */
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    /**
     * This method will dismiss the alert
     */
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    /**
     * This method will get text from the alert
     */
    public void getTextFromAlert(){
        driver.switchTo().alert().getText();
    }

    /**
     * This method will send keys to the alert
     */
    public void sendKeysToAlert(){
        driver.switchTo().alert().sendKeys("text");
    }


    //************************ Select class methods********************************************//
    /**
     * This method will select the option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text){
       WebElement dropDown = driver.findElement(by);
       Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    /**
     * This method will select the option by value
     */
    public void selectByValueFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }
    /**
     * This method will select the option by index
     */
    public void selectByIndexFromDropDown(By by, int index){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }
    //**********************Mouse Hover methods ****************************************//

    public void mouseHover(By by) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement mouseHover = driver.findElement(by);
        Thread.sleep(3000);
        actions.moveToElement(mouseHover).build().perform();
    }
    public void mouseHoverAndClick(By by) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement mouseHover = driver.findElement(by);
        Thread.sleep(3000);
        actions.moveToElement(mouseHover).click().build().perform();
    }

    //*****************************Assert Verify Methods ***********************************************//
    public void verifyElements(String displayMessage, String expectedMessage, By by){
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
    }
}
