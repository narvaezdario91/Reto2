package com.litethinking.features;

import com.litethinking.pages.MenuPage;
import com.litethinking.pages.checkout.CheckoutOnePage;
import com.litethinking.pages.ShoppingCartPage;
import com.litethinking.pages.checkout.CheckoutThreePage;
import com.litethinking.pages.checkout.CheckoutTwoPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShoppingE2ETest extends BaseTest{
    InventoryTest inventoryTest = new InventoryTest();

    @Test
    public void shoppingProducts(){
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(getDriver());
        CheckoutOnePage checkoutOnePage = new CheckoutOnePage(getDriver());
        CheckoutTwoPage checkoutTwoPage = new CheckoutTwoPage(getDriver());
        CheckoutThreePage checkoutThreePage = new CheckoutThreePage(getDriver());
        MenuPage menuPage = new MenuPage(getDriver());

        inventoryTest.addFiveProducts();
        inventoryTest.goToCart();

        shoppingCartPage.clickOnCheckoutButton();
        checkoutOnePage.checkout("Dario","Narvaez", "34342");

        Assertions.assertEquals(inventoryTest.getTotalPrice(), checkoutTwoPage.getSubtotal());

        checkoutTwoPage.clickOnFinishButton();
        checkoutThreePage.isTextCheckoutCompleteDisplayed();

        menuPage.logoutUser();

    }

}
