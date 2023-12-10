package com.litethinking.features;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {
    static WebDriver driver;
    int IMPLICIT_TIME = 5;
    String URL_BASE = "https://www.saucedemo.com/";

    @BeforeEach
    public void setup(){
        LoginTest loginTest = new LoginTest();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_TIME));
        driver.manage().window().maximize();
        driver.get(URL_BASE);
        loginTest.loginSuccess();

    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }

}
