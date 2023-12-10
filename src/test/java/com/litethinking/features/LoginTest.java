package com.litethinking.features;

import com.litethinking.pages.InventoryPage;
import com.litethinking.pages.LoginPage;
import org.junit.jupiter.api.Test;
public class LoginTest extends BaseTest{

    public void loginSuccess(){
        LoginPage loginPage = new LoginPage(getDriver());
        InventoryPage inventoryPage = new InventoryPage(getDriver());

        loginPage.loginUser("standard_user", "secret_sauce");
        inventoryPage.isInventoryListVisible();
        inventoryPage.isShoppingCartVisible();
    }

}
