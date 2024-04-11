package screens.requests;

import elements.Button;
import io.appium.java_client.AppiumBy;
import screens.BaseScreen;

public class RequestsScreen implements BaseScreen {
    public Button updateButton = new Button(
            AppiumBy.xpath("//android.widget.Button[@content-desc=\"busy\"]"),
            "Скачать и Обновить");

    public Button createRequestButton = new Button(
            AppiumBy.xpath("//android.widget.TextView[@text=\"\uE145\"]//ancestor::android.widget.Button[1]"),
            "Cоздание заявки");
}
