package screens.requests;

import elements.Button;
import io.appium.java_client.AppiumBy;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class CreatedRequestScreen {
    public Button backButton = new Button(
            AppiumBy.xpath("(//android.widget.Button[@resource-id=\"RNE__ICON__CONTAINER_ACTION\"])[1]"),
            "Назад");
    public Button chatButton = new Button(
            AppiumBy.xpath("(//android.widget.Button[@resource-id=\"RNE__ICON__CONTAINER_ACTION\"])[2]"),
            "Чат");
    public Button cancelRequestButton = new Button(
            AppiumBy.xpath("//android.widget.TextView[@text=\"Отменить\"]/.."),
            "Отменить заявку");
    public Button refusalServiceButton = new Button(
            AppiumBy.xpath("//android.widget.TextView[@text=\"Отказ\"]/.."),
            "Отказ от услуги");
    public Button editRequestButton = new Button(
            AppiumBy.xpath("//android.widget.TextView[@text=\"Редактировать\"]/.."),
            "Редактировать");
    public Button copyRequestButton = new Button(
            AppiumBy.xpath("//android.widget.TextView[@text=\"Скопировать\"]/.."),
            "Скопировать");

}
