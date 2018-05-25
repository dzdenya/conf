import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{
    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void userLogin(String password) {
        type(By.name("p"), "123");
        click(By.cssSelector("input.btn.btn-primary"));
    }
}
