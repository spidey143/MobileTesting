package screens;

import elements.base.Button;
import io.appium.java_client.AppiumBy;

public class PersonalCabinetScreen {
    public Button exitButton = new Button(
            AppiumBy.xpath("//android.widget.TextView[@text=\"Выйти\"]"),
            "Выйти");
}
