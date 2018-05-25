import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AddNewFeature extends TestBase {

    @Test(enabled = false)
    public void testAddNewFeature() {
        app.initChooseValue(By.xpath("//option[text()='Коды ошибок']"));
        app.goTo().addNewFeature();
        app.getFillFormHelper().fillAddNewFeature();


    }


}
