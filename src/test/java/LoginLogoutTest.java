import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginLogoutTest extends TestBase {
    WebDriver driver;
    private MainPage mainPage;

    @Test(enabled = false)
    public void testLogout() {
        app.goTo().gotoLogout();
    }
}
