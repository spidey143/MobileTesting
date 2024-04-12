package screens.requests;

import elements.Button;
import io.appium.java_client.AppiumBy;

public class CreatedRequestScreen {
    public Button backButton = new Button(
            AppiumBy.xpath("(//android.widget.Button[@resource-id=\"RNE__ICON__CONTAINER_ACTION\"])[1]"),
            "Назад");
    public Button chatButton = new Button(
            AppiumBy.xpath("(//android.widget.Button[@resource-id=\"RNE__ICON__CONTAINER_ACTION\"])[2]"),
            "Чат");
}
