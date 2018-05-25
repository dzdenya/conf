import model.MaterialData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DeleteTestMaterials extends TestBase{

    @Test()
    public void testDelete() {
        app.goTo().materials();
        List<MaterialData> before = app.goTo().getMaterialList();
        app.goTo().initModification(before.size() - 1);
        app.deleteSelected();
        app.alertAccept();
        app.getFillFormHelper().waitPage();
        List<MaterialData> after = app.goTo().getMaterialList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }

}
