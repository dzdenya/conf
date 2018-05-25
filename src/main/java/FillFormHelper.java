import model.MaterialData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FillFormHelper extends HelperBase {

    public FillFormHelper(WebDriver driver) {
        super(driver);
    }

    public void fillAddNewFeatureEcodes() {
        if (!driver.findElement(By.xpath("//td[text()='Тип']/following-sibling::td")).isSelected()) {
            int a = (int) (Math.random() * 3 + 2);
            System.out.println("Выбран элемент :" + a);
            click(By.xpath("//*[@id='minpttyp']/option[" + a + "]"));
        }
        type(By.xpath("//td[text()='Сообщение']/following-sibling::td/input"), "Test1");
        type(By.xpath("//td[text()='Причина']/following-sibling::td/input"), "Test1");
        type(By.xpath("//td[text()='Решение']/following-sibling::td/input"), "Test1");
        if (!driver.findElement(By.xpath("//td[text()='Типы устройства']/following-sibling::td")).isSelected()) {
            int a = (int) (Math.random() * 44 + 2);
            System.out.println("Выбран элемент :" + a);
            click(By.xpath("//*[@id='minptdtypes']/option[" + a + "]"));
        }
    }

    public void fillAddNewFeatureCurrencies() {
        type(By.xpath("//td[text()='Название']/following-sibling::td/input"), "Test1");
        click(By.xpath("//*[@id='minptactive']"));
    }

    public void fillAddNewFeatureMaterials(MaterialData material) {
        type(By.xpath("//td[text()='Название']/following-sibling::td/input"), material.getName());
        type(By.xpath("//td[text()='Кол-во']/following-sibling::td/input"), material.getVolume());
        if (!driver.findElement(By.xpath("//td[text()='Единицы измерения']/following-sibling::td")).isSelected()) {
            int a = (int) (Math.random() * 25 + 2);
            System.out.println("Выбран элемент :" + a);
            click(By.xpath("//*[@id='minptmeas']/option[" + a + "]"));
        }
        type(By.xpath("//td[text()='Стоимость']/following-sibling::td/input"), material.getPrise());
        if (!driver.findElement(By.xpath("//td[text()='Валюта']/following-sibling::td")).isSelected()) {
            int a = (int) (Math.random() * 3 + 2);
            System.out.println("Выбран элемент :" + a);
            click(By.xpath("//*[@id='minptcurr']/option[" + a + "]"));
        }
        click(By.xpath("//*[@id='minptactive']"));
        click(By.xpath("//*[@id='dmodal_savbtn']"));
        waitPage();
    }

    public void waitPage() {
        try {
            Thread.sleep(1000);
            driver.navigate().refresh();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void fillAddNewFeature() {
        type(By.xpath("//td[text()='Примечание']/following-sibling::td/input"), "Test1");
        type(By.xpath("//td[text()='Описание']/following-sibling::td/input"), "Test1");
        click(By.xpath("//td[text()='Контроллер']/following-sibling::td/input"));
        // выбрать селектор
        type(By.xpath("//td[text()='Вес']/following-sibling::td/input"), "Test1");
        type(By.xpath("//td[text()='Фактический номер']/following-sibling::td/input"), "Test1");
        type(By.xpath("//td[text()='Производительность']/following-sibling::td/input"), "Test1");
        type(By.xpath("//td[text()='Дата выпуска']/following-sibling::td/input"), "Test1");
        click(By.xpath("//*[@id='minptactive']"));
    }
}
