package pages.theinternetheroku;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class DrugAndDropPage extends BasePage {

    private static final String BASE_URN = "https://the-internet.herokuapp.com/drag_and_drop";

    public static final By COLUMN_A = By.id("column-a");
    public static final By COLUMN_B = By.id("column-b");

    public DrugAndDropPage(WebDriver driver) {
        super(driver);
    }

    public void dragAndDropLeftToRight() {
        Actions actions = new Actions(driver);
        WebElement columnLeft = driver.findElement(COLUMN_A);
        WebElement columnRight = driver.findElement(COLUMN_B);
        actions.dragAndDrop(columnLeft, columnRight).perform();
    }

    public void dragAndDropActionsRightToLeft() {
        Actions actions = new Actions(driver);
        WebElement columnLeft = driver.findElement(COLUMN_A);
        WebElement columnRight = driver.findElement(COLUMN_B);
        actions.clickAndHold(columnLeft).release(columnRight).perform();
    }

    public void dragAndDropJSRightToLeft() {
        WebElement columnLeft = driver.findElement(COLUMN_A);
        WebElement columnRight = driver.findElement(COLUMN_B);
        File script = new File("src/main/resources/native_js_drag_and_drop_helper.js");
        Path scriptPath = Path.of(script.getAbsolutePath());
        String jsFunction = "";
        try {
            jsFunction = Files.readString(scriptPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ((JavascriptExecutor)driver).executeScript(jsFunction + "simulateDragDrop(arguments[0], arguments[1]);",
                columnLeft, columnRight);
    }

    public String getTextFromLeftColumn() {
        return driver.findElement(COLUMN_A).getText();
    }

    public String getTextFromRightColumn() {
        return driver.findElement(COLUMN_B).getText();
    }

    @Override
    public boolean isPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(COLUMN_A));
        return true;
    }

    @Override
    public void openPage() {
        driver.get(BASE_URN);
    }

}
