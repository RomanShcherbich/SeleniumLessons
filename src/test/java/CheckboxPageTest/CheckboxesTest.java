package CheckboxPageTest;

import BaseTest.BaseTest;
import org.testng.annotations.Test;
import pages.theinternetheroku.CheckboxesPage;

public class CheckboxesTest extends BaseTest {

    @Test
    public void checkAttributeOfCheckbox1(){
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
        checkboxesPage.openPage();
        validatePageIsLoaded(checkboxesPage);
        checkboxesPage.findCheckBoxes("Checkbox 1");
    }

    @Test
    public void checkAttributeOfCheckbox2(){
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
        checkboxesPage.openPage();
        validatePageIsLoaded(checkboxesPage);
        checkboxesPage.findCheckBoxes("Checkbox 2");
    }

}
