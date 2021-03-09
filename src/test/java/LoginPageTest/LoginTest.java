package LoginPageTest;

import BaseTest.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.ProductsPage;

import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;

public class LoginTest extends BaseTest {

    public static final String STANDARD_USER = "standard_user";
    public static final String VALID_PASSWORD = "secret_sauce";

    @Test
    public void validAuthenticationTest() {
        loginPage.openPage();
        validatePageIsLoaded(loginPage);
        Assert.assertTrue(loginPage.waitForPageLoaded());
        loginPage.authentication(STANDARD_USER, VALID_PASSWORD);
        FluentWait<ProductsPage> fluentWait = new FluentWait<>(productsPage);
        fluentWait.withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(productsPage1 -> productsPage1.isPageLoaded());
        Assert.assertEquals(productsPage.getPageUrl(), ProductsPage.BASE_URN,
                String.format("Url after login [%s] is not equal", productsPage.getPageUrl()));
    }

}
