package SeleniumAdvancedTest;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.theinternetheroku.HoversPage;

public class HoversTest extends BaseTest {


    @Test
    public void HoverTest(){
        HoversPage hoversPage = new HoversPage(driver);
        hoversPage.openPage();
        validatePageIsLoaded(hoversPage);
        Assert.assertEquals(hoversPage.getUserLink("user2"),
                "https://the-internet.herokuapp.com/users/1", "User link is not valid: ");
    }

}
