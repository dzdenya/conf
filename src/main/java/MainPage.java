import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By logout = By.xpath("//div[@class='hta_right']/input");

    public MainPage logout(){
        driver.findElement(logout);
        return this;
    }
}
