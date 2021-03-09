package SeleniumAdvancedTest;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.theinternetheroku.DrugAndDropPage;

public class DrugAndDropTest extends BaseTest {

    @Test
    public void DrugAndDropTest() {
        DrugAndDropPage drugAndDropPage = new DrugAndDropPage(driver);
        drugAndDropPage.openPage();
        validatePageIsLoaded(drugAndDropPage);
        Assert.assertEquals(drugAndDropPage.getTextFromLeftColumn(), "A", "Invalid initiate condition");
        Assert.assertEquals(drugAndDropPage.getTextFromRightColumn(), "B", "Invalid initiate condition");
        drugAndDropPage.dragAndDropActionsRightToLeft();
        Assert.assertEquals(drugAndDropPage.getTextFromLeftColumn(), "B", "drug and drop failed");
        Assert.assertEquals(drugAndDropPage.getTextFromRightColumn(), "A", "drug and drop failed");
    }

    @Test
    public void DrugAndDropWithJsTest() {
        DrugAndDropPage drugAndDropPage = new DrugAndDropPage(driver);
        drugAndDropPage.openPage();
        validatePageIsLoaded(drugAndDropPage);
        Assert.assertEquals(drugAndDropPage.getTextFromLeftColumn(), "A", "Invalid initiate condition");
        Assert.assertEquals(drugAndDropPage.getTextFromRightColumn(), "B", "Invalid initiate condition");
        drugAndDropPage.dragAndDropJSRightToLeft();
        Assert.assertEquals(drugAndDropPage.getTextFromLeftColumn(), "B", "drug and drop failed");
        Assert.assertEquals(drugAndDropPage.getTextFromRightColumn(), "A", "drug and drop failed");
    }

}
