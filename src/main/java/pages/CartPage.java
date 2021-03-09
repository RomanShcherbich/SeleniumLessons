package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    public static final String BASE_URN = "https://www.saucedemo.com/cart.html";
    public static final By PAGE_HEADER_BY = By.className("subheader");
    public static final String PAGE_HEADER_TEXT = "Your Cart";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageLoaded() {
        WebElement element = driver.findElement(PAGE_HEADER_BY);
//        explicitlyWait.until(ExpectedConditions.invisibilityOf(element));
        explicitlyWait.until(ExpectedConditions.attributeToBe(PAGE_HEADER_BY, "test", ""));

        explicitlyWait.until(ExpectedConditions.textToBe(PAGE_HEADER_BY, PAGE_HEADER_TEXT));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_HEADER_BY));
        return true;
    }

    @Override
    public void openPage() {
        driver.get(BASE_URN);
    }

}
