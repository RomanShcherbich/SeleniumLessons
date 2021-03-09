package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDateTime;

public class ProductsPage extends BasePage {

    public static final String BASE_URN = "https://www.saucedemo.com/inventory.html";
    public static final By CART_BUTTON = By.className("svg-inline--fa");
    public static final By INVENTORY_CONTAINER = By.id("inventory_container");
    public static final String PRODUCT_LOCATOR_PATTERN =
            "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//button";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart(String productTitle) {
        By productButton = By.xpath(String.format(PRODUCT_LOCATOR_PATTERN, productTitle));
        driver.findElement(productButton).click();
    }

    public void openCart() {
        driver.findElement(CART_BUTTON).click();
    }

    @Override
    public boolean isPageLoaded() {
//        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(INVENTORY_CONTAINER));
        System.out.println("FLUENT WAIT - " + LocalDateTime.now());
        driver.findElement(INVENTORY_CONTAINER);
        return true;
    }

    @Override
    public void openPage() {
        driver.get(BASE_URN);
    }

}
