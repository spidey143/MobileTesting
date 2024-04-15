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

    public Button cancelRequestButton = new Button(AppiumBy.xpath(""), "Отменить заявку"); //TODO locator
    public Button refusalServiceButton = new Button(AppiumBy.xpath(""), "Отказ от услуги");//TODO locator
    public Button editRequestButton = new Button(AppiumBy.xpath(""), "Редактировать");//TODO locator
    public Button copyRequestButton = new Button(AppiumBy.xpath(""), "Скопировать");//TODO locator

}
