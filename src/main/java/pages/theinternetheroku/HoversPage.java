package pages.theinternetheroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HoversPage extends BasePage {

    private static final String BASE_URN = "https://the-internet.herokuapp.com/hovers";

    public static final By HOVERS = By.className("figure");
    public static final By BOX_CAPTION = By.className("figcaption");
    public static final Map<String, FigureCapture> userMap = new HashMap<>();


    public HoversPage(WebDriver driver) {
        super(driver);
    }

    private void initiateUserMap() {
        List<WebElement> users = driver.findElements(HOVERS);
        List<WebElement> userCaptionList = driver.findElements(BOX_CAPTION);
        for (WebElement el : users) {
            int index = users.indexOf(el);
            Actions actions = new Actions(driver);
            actions.moveToElement(el).perform();
            WebElement userCaption = userCaptionList.get(index);
            explicitlyWait.until(ExpectedConditions.visibilityOf(userCaption));
            FigureCapture userCapture = new FigureCapture(userCaption);
            userMap.put(userCapture.getUserName(), userCapture);
        }
    }

    public Map<String, FigureCapture> getUserMap() {
        if (userMap.isEmpty()) {
            initiateUserMap();
        }
        return userMap;
    }

    public String getUserLink(String username) {
        return getUserMap().get(username).getUserLink();
    }

    @Override
    public boolean isPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HOVERS));
        return true;
    }

    @Override
    public void openPage() {
        driver.get(BASE_URN);
    }

    public class FigureCapture {

        public final By USER_NAME = By.tagName("h5");
        public final By USER_LINK = By.tagName("a");
        private WebElement userCapture;

        public FigureCapture(WebElement userCapture) {
            this.userCapture = userCapture;
        }

        public String getUserName() {
            String username = userCapture.findElement(USER_NAME).getText();
            return username.split(":")[1].trim();
        }


        public String getUserLink() {
            return userCapture.findElement(USER_LINK).getAttribute("href");
        }

    }

}
