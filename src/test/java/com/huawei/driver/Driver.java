package com.huawei.driver;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {
    public static WebDriver driver;
    public static Actions actions;

    ChromeOptions chromeOptions;

    @BeforeScenario
    public void beforeTest(){
        driver = new ChromeDriver(chromeOptions());
    }

    @AfterScenario
    public void afterTest() {
        if(driver!=null) {
            driver.quit();
        }
    }

    public ChromeOptions chromeOptions() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--kiosk");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--start-fullscreen");
        return chromeOptions;
    }

    public static WebDriver getWebDriver() {
        return driver;
    }
}
