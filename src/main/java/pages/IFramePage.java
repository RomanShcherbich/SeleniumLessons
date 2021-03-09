package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IFramePage extends BasePage {

    private static final String BASE_URN = "https://the-internet.herokuapp.com/tinymce";

    private static final String IFRAME_ID = "mce_0_ifr";
    private static final By IFRAME = By.id(IFRAME_ID);
    private static final By BODY_EDITOR = By.id("tinymce");
    private static final By BOLD_BUTTON = By.xpath("//button[@title='Bold']");
    private static final By FONT_STATUS = By.xpath("//div[@class='tox-statusbar__path-item' and contains(.,'strong')]");


    public IFramePage(WebDriver driver) {
        super(driver);
    }

    public String getEditorText() {
        driver.switchTo().frame(IFRAME_ID);
        String text = driver.findElement(BODY_EDITOR).getText();
        driver.switchTo().parentFrame();
        return text;
    }

    public boolean clickBoldButton(){
        try {
            driver.findElement(BOLD_BUTTON).click();
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(FONT_STATUS));
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isPageLoaded() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(IFRAME));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    @Override
    public void openPage() {
        driver.get(BASE_URN);
    }

    public boolean openPageWithValidation() {
        driver.get(BASE_URN);
        return isPageLoaded();
    }


}
