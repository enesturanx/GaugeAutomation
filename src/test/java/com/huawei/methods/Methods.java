package com.huawei.methods;

import com.huawei.driver.Driver;
import com.huawei.helper.ElementHelper;
import com.huawei.helper.StoreHelper;
import com.huawei.model.ElementInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

public class Methods {
    public WebDriver driver;
    public Actions actions;
    public WebDriverWait webDriverWait;
    public FluentWait<WebDriver> wait;
    private final int timeOut = 30;
    private final int sleepTime = 150;

    public Methods(){
    this.driver = Driver.getWebDriver();
    this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(sleepTime));
    wait = new FluentWait<>(driver);
    wait.withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofMillis(300))
            .ignoring(NoSuchElementException.class);
    this.actions = new Actions(driver);
    }

    public WebElement findElement(String key){
        ElementInfo elementInfo = StoreHelper.INSTANCE.findElementInfoByKey(key);
        By info = ElementHelper.getElementInfoToBy(elementInfo);
        return wait.until(ExpectedConditions.presenceOfElementLocated(info));
    }

    public void clickElement(String key){
        findElement(key).click();
    }

    public void sendText(String key, String text){
        findElement(key).sendKeys(text);
    }

    public void waitSecond(long seconds){
        try {
            Thread.sleep(seconds * 1000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void waitMiliSecond(long miliseconds){
        try {
            Thread.sleep(miliseconds);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void clearElement(String key){
        findElement(key).clear();
    }

    public boolean isElementVisible(String key){

        try {
            ElementInfo elementInfo = StoreHelper.INSTANCE.findElementInfoByKey(key);
            By infoParam = ElementHelper.getElementInfoToBy(elementInfo);
            wait.until(ExpectedConditions.visibilityOfElementLocated(infoParam));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void checkElementVisible(String key){
        assertTrue(isElementVisible(key), "element could not be displayed");
    }

    public boolean isElementClickable(String key){

        try {
            ElementInfo elementInfo = StoreHelper.INSTANCE.findElementInfoByKey(key);
            By infoParam = ElementHelper.getElementInfoToBy(elementInfo);
            wait.until(ExpectedConditions.elementToBeClickable(infoParam));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void checkElementClickable(String key){
        assertTrue(isElementClickable(key), "element is not clickable");
    }

    public String getTextValue(String key){
        return findElement(key).getText();
    }

    public String getAttributeValue(String key, String attribute){
        return findElement(key).getAttribute(attribute);
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public void goToURL(String url){
        driver.navigate().to(url);
    }

}
