package com.litethinking.pages.checkout;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutThreePage {
    public CheckoutThreePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "finish")
    WebElement finishButton;
    @FindBy(id = "checkout_complete_container")
    WebElement checkoutComplete;

    public void isTextCheckoutCompleteDisplayed(){
        WebElement textCheckoutComplete = checkoutComplete.findElement(By.xpath(".//h2"));
        Assertions.assertEquals("Thank you for your order!", textCheckoutComplete.getText());
    }
}
