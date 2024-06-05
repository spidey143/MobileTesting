package screens;

import elements.base.Button;
import elements.base.SelectForm;
import elements.base.TextField;
import elements.pickers.DatePicker;
import elements.pickers.TimePicker;
import io.appium.java_client.AppiumBy;

public class EditRequestScreen {
    public Button confirmEditRequestButton = new Button(
            AppiumBy.xpath("//android.widget.TextView[@text=\"Редактировать\"]"),
            "Редактировать");
}
