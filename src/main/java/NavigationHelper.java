import model.MaterialData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class NavigationHelper extends HelperBase {
    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public By main = By.xpath("//*[@id='dmenu']/option[1]");
    public By ecodes = By.xpath("//option[text()='Коды ошибок']");
    public By currencies = By.xpath("//option[text()='Виды валют']");
    public By materials = By.xpath("//option[text()='ТМЦ']");
    public By viewgrps = By.xpath("//option[text()='Виды отображения данных']");
    public By viewtypes = By.xpath("//option[text()='Типы отображения']");
    public By plists = By.xpath("//option[text()='Комплектность']");
    public By strucs = By.xpath("//option[text()='Структуры данных']");
    public By cpass = By.xpath("//option[text()='Паспорта']");
    public By modules = By.xpath("//option[text()='Модули']");
    public By ctrls = By.xpath("//option[text()='Контроллеры']");
    public By ccla = By.xpath("//option[text()='Классы контроллеров']");
    public By dev_grps = By.xpath("//option[text()='Группы устройств']");
    public By dtypes = By.xpath("//option[text()='Типы устройства']");
    public By dcontypes = By.xpath("//option[text()='Типы связи устройств']");
    public By dmodif = By.xpath("//option[text()='Модификации устройств']");
    public By sgrps = By.xpath("//option[text()='Группы статусов']");
    public By meas = By.xpath("//option[text()='Единицы измерения']");
    public By usrs = By.xpath("//option[text()='Пользователи']");
    public By ugrps = By.xpath("//option[text()='Деятельности']");
    public By logout = By.xpath("//div[@class='hta_right']/input");

    public void addNewFeature() {
        click(By.xpath("//div[@class='hta_right']/input[1]"));
    }

    public void main() {
        click(main);
    }

    public void gotoecodes() {
        click(ecodes);
    }

    public void gotocurrencies() {
        click(currencies);
    }

    public void materials() {
//        if(isElementPresent(By.xpath("//th[text()='Название']"))
//                && isElementPresent(By.xpath("//th[text()='Кол-во']"))
//                && isElementPresent(By.xpath("//th[text()='Единицы измерения']"))){
//        driver.navigate().refresh();
//            return;
//        }
//        if (!driver.findElement(By.xpath("//option[text()='ТМЦ']")).isSelected())
//        driver.findElement(By.xpath("//option[text()='ТМЦ']")).click();
//        click(materials);

        WebElement selectElem  = driver.findElement(By.xpath("//*[@id='dmenu']"));
        Select select = new Select(selectElem );
        select.selectByValue("materials");
//        listValue.click();
    }





    public void gotoviewgrps() {
        click(viewgrps);
    }

    public void gotoviewtypes() {
        click(viewtypes);
    }

    public void gotoplists() {
        click(plists);
    }

    public void gotostrucs() {
        click(strucs);
    }

    public void gotocpass() {
        click(cpass);
    }

    public void gotomodules() {
        click(modules);
    }

    public void gotoctrls() {
        click(ctrls);
    }

    public void gotoccla() {
        click(ccla);
    }

    public void gotodev_grps() {
        click(dev_grps);
    }

    public void gotodtypes() {
        click(dtypes);
    }

    public void gotodcontypes() {
        click(dcontypes);
    }

    public void gotodmodif() {
        click(dmodif);
    }

    public void gotosgrps() {
        click(sgrps);
    }

    public void gotomeas() {
        click(meas);
    }

    public void gotousrs() {
        click(usrs);
    }

    public void gotougrps() {
        click(ugrps);

    }

    public void gotoLogout() {
        click(logout);
    }

    public void initModification(int index) {
        driver.findElements(By.xpath("//input[@title='Изменить']")).get(index).click();
    }

    public int getCountTable() {
       return driver.findElements(By.xpath("//input[@title='Изменить']")).size();
    }

    public List<MaterialData> getMaterialList() {
        List<MaterialData> materials = new ArrayList<MaterialData>();
        List<WebElement> elements = driver.findElements(By.xpath("//td[@data-label='Название']"));
        for (WebElement element: elements) {
            String name = element.getText();
            int id = Integer.parseInt(driver.findElement(By.xpath("//td[@data-label='ID']")).getText());
            MaterialData material = new MaterialData(id, name, null, null);
            materials.add(material);
        }
        return materials;
    }
}
