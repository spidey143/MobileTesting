package screens;

import elements.Button;
import io.appium.java_client.AppiumBy;

public class RequestsScreen {
    public Button updateButton = new Button(
            AppiumBy.xpath("//android.widget.Button[@content-desc=\"busy\"]"),
            "Кнопка 'Скачать и Обновить'");

    public Button createRequestButton = new Button(
            AppiumBy.xpath("//android.widget.Button[@content-desc=\"create\"]"),
            "Кнопка 'Cоздание заявки'");
}
