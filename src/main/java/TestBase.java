import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;

public class TestBase {

    public static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app.stop();
    }

}
