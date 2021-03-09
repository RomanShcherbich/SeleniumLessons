package ProductPageTest;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;

public class ProductsPageTest extends BaseTest {

    public static final String PRODUCT_SAUCE_LABS_BACKPACK = "Sauce Labs Backpack";
    public static final String PRODUCT_TEST = "Test.allTheThings() T-Shirt (Red)";

    @Test
    public void addProductToCart() {
        loginPage.openPage();
        validatePageIsLoaded(loginPage);
        loginPage.authentication("standard_user", "secret_sauce");
        Assert.assertEquals(productsPage.getPageUrl(), ProductsPage.BASE_URN,"Url after login is not equal");
        productsPage.addProductToCart(PRODUCT_TEST);
        productsPage.openCart();
        Assert.assertEquals(cartPage.getPageUrl(), CartPage.BASE_URN,"Url after login is not equal");
        validatePageIsLoaded(cartPage);
    }

}
