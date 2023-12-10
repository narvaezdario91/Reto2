package com.litethinking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {
    public MenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutButton;

    @FindBy(id = "react-burger-menu-btn")
    WebElement menuButton;

    public void logoutUser(){
        menuButton.click();
        logoutButton.click();
    }
}
