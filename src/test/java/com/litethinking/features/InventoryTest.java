package com.litethinking.features;

import com.litethinking.pages.InventoryPage;
import com.litethinking.pages.ShoppingCartPage;
import org.junit.jupiter.api.Test;
public class InventoryTest extends BaseTest{

    private float totalPrice = 0f;
    @Test
    public void addFiveProducts(){
        int quantityProducts = 5;
        InventoryPage inventoryPage = new InventoryPage(getDriver());

        totalPrice = inventoryPage.addProductsToCart(quantityProducts);
        inventoryPage.hasProductsTheCart(quantityProducts);
    }

    @Test
    public void goToCart(){
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(getDriver());

        inventoryPage.clickOnCart();
        shoppingCartPage.isContinueShoppingButtonVisible();
        shoppingCartPage.isCheckoutButtonVisible();
    }

    public float getTotalPrice(){
        return totalPrice;
    }
}
