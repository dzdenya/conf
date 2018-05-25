import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver driver;
    private FillFormHelper fillFormHelper;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private MainPage mainPage;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    protected void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\Projects\\testUdemy\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Projects\\testUdemy\\drivers\\geckodriver.exe");
        if(browser.equals(BrowserType.CHROME)){
            driver = new ChromeDriver();
        } else if(browser.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            driver.manage().window().maximize();
        } catch (Exception e) {
            System.out.println("");
        }
        driver.get("http://192.168.15.22:3000/auth");
        sessionHelper = new SessionHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper.userLogin("123");
        fillFormHelper = new FillFormHelper(driver);
    }


    protected void initChooseValue(By xpath) {
        if (!driver.findElement(xpath).isSelected()) {
            driver.findElement(xpath).click();
        }
    }

    protected void stop() {
        driver.quit();
    }

    protected void deleteSelected() {
        driver.findElement(By.id("dmodal_delbtn")).click();
    }

    protected void alertAccept() {
        driver.switchTo().alert().accept();
    }

    public FillFormHelper getFillFormHelper() {
        return fillFormHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public static boolean isAlertPresent(WebDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

}
