import model.MaterialData;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Comparator;
import java.util.List;

public class AddNewMaterials extends TestBase{

    @Test
    public void testAddNewFeature() {
        app.goTo().materials();
        List<MaterialData> before = app.goTo().getMaterialList();
        app.goTo().addNewFeature();
        MaterialData material = new MaterialData("Test2", "100", "100");
        app.getFillFormHelper().fillAddNewFeatureMaterials(material);
        List<MaterialData> after = app.goTo().getMaterialList();

        Assert.assertEquals(after.size(), before.size() + 1);

        material.setId(after.stream().max(Comparator.comparingInt(MaterialData::getId)).get().getId());
        before.add(material);
        Assert.assertEquals(before, after);

    }
}
