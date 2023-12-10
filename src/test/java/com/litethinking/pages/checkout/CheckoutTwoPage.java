package com.litethinking.pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutTwoPage {
    public CheckoutTwoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "finish")
    WebElement finishButton;

    @FindBy(xpath = "//div[@id='checkout_summary_container']//div[@class='summary_subtotal_label']")
    WebElement subtotalLabel;

    public float getSubtotal(){
        return Float.valueOf(subtotalLabel.getText().replace("Item total: $", ""));
    }

    public void clickOnFinishButton(){
        finishButton.click();
    }
}
