package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait explicitlyWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.explicitlyWait = new WebDriverWait(driver, 10);
    }

    public void setExplicitlyWaitTimeout(int timeOutInSeconds) {
        this.explicitlyWait = new WebDriverWait(driver, timeOutInSeconds);
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    abstract public boolean isPageLoaded();

    abstract public void openPage();

    public boolean waitForPageLoaded() {
        String state = ((JavascriptExecutor) driver).executeScript("return document.readyState").toString();
        System.out.println("JAVA SCRIPT WAITER = ".concat(state));
        return state.equals("complete");
    }


}
