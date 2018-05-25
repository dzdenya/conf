import model.MaterialData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;


public class ModificationTest extends TestBase{

    @Test
    public void testModification(){
        app.goTo().materials();
        List<MaterialData> before = app.goTo().getMaterialList();
        app.goTo().initModification(before.size() - 1);
        MaterialData material = new MaterialData(before.get(before.size() -1).getId(), "Test1", "100", "100");
        app.getFillFormHelper().fillAddNewFeatureMaterials(material);
        List<MaterialData> after = app.goTo().getMaterialList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(material);

        Comparator<? super MaterialData> byId = Comparator.comparingInt(MaterialData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }
}
