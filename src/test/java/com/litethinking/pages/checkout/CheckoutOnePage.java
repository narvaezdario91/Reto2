package com.litethinking.pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOnePage {

    public CheckoutOnePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "first-name")
    WebElement firstNameInput;
    @FindBy(id = "last-name")
    WebElement lastNameInput;
    @FindBy(id = "postal-code")
    WebElement zipInput;
    @FindBy(id = "continue")
    WebElement continueButton;


    public void checkout(String firstName, String lastName, String zipCode){
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        zipInput.clear();
        zipInput.sendKeys(zipCode);

        continueButton.click();
    }
}
