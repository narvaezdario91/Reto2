package com.litethinking.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

public class InventoryPage{

    public InventoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    DecimalFormatSymbols symbols= DecimalFormatSymbols.getInstance(Locale.ENGLISH);
    @FindBy(id = "shopping_cart_container")
    WebElement shoppingCartButton;
    @FindBy(id = "inventory_container")
    WebElement inventoryContainerDiv;
    @FindAll({@FindBy(className = "inventory_item")})
    List<WebElement> listProducts;

    private static String XPATH_ADD_BUTTON = ".//button[contains(text(),'Add to cart')]";
    private static String XPATH_PRICE_PRODUCT = ".//div[contains(@class,'inventory_item_price')]";
    private static String XPATH_BADGE_CART = "//span[contains(@class,'shopping_cart_badge')]";

    public void isShoppingCartVisible(){
        Assertions.assertEquals(true, shoppingCartButton.isDisplayed());
    }

    public void isInventoryListVisible(){
        Assertions.assertEquals(true, inventoryContainerDiv.isDisplayed());
    }

    public float addProductsToCart(int quantity){
        int size = listProducts.size()>=quantity?quantity:listProducts.size();
        float totalPrice = 0;
        int index = 1;
        for (WebElement product: listProducts) {
            product.findElement(By.xpath(XPATH_ADD_BUTTON)).click();
            float productPrice = Float.valueOf(
                    product.findElement(
                            By.xpath(XPATH_PRICE_PRODUCT)
                    ).getText().replace("$", ""));
            totalPrice = totalPrice + productPrice;
            if(index==size) break;
            index++;
        }
        return Float.valueOf(new DecimalFormat("#.##",symbols).format(totalPrice));
    }

    public void hasProductsTheCart(int quantity){
        int productsOnCart = Integer.parseInt(shoppingCartButton.findElement(By.xpath(XPATH_BADGE_CART)).getText());
        Assertions.assertEquals(quantity, productsOnCart);
    }

    public void clickOnCart(){
        shoppingCartButton.click();
    }
}
