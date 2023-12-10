package com.litethinking.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    public ShoppingCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "checkout")
    WebElement checkoutButton;
    @FindBy(id = "continue-shopping")
    WebElement continueShoppingButton;

    public void isCheckoutButtonVisible(){
        Assertions.assertEquals(true, checkoutButton.isDisplayed());
    }

    public void isContinueShoppingButtonVisible(){
        Assertions.assertEquals(true, continueShoppingButton.isDisplayed());
    }

    public void clickOnCheckoutButton(){
        checkoutButton.click();
    }

}
