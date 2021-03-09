package IFrameTest;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IFramePage;

public class IFrameTest extends BaseTest {

    @Test
    public void getIFrameTest() {
        IFramePage iFramePage = new IFramePage(driver);
        Assert.assertTrue(iFramePage.openPageWithValidation());
        Assert.assertEquals(iFramePage.getEditorText(), "Your content goes here.");
        Assert.assertTrue(iFramePage.clickBoldButton());
    }

}
