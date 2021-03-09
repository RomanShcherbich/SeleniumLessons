package pages.theinternetheroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.util.List;

public class CheckboxesPage extends BasePage {

    private static final String BASE_URN = "https://the-internet.herokuapp.com/checkboxes";

    public static final By FORM = By.id("checkboxes");
    public static final By CHECKBOXES = By.tagName("input");

    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }

    public void findCheckBoxes(String checkboxName) {
        List<WebElement> checkboxes = driver.findElements(CHECKBOXES);
        String[] checkboxesValues = driver.findElement(FORM).getText().split("\n");
        WebElement foundCheckbox = null;
        for (WebElement el : checkboxes) {
            int index = checkboxes.indexOf(el);
            if (checkboxesValues[index].equalsIgnoreCase(checkboxName)) {
                foundCheckbox = el;
                break;
            }
        }
        explicitlyWait.until(ExpectedConditions.elementToBeSelected(foundCheckbox));
    }

    @Override
    public boolean isPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(FORM));
        return true;
    }

    @Override
    public void openPage() {
        driver.get(BASE_URN);
    }

}
