package screens.baggageDelivery;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import io.appium.java_client.AppiumBy;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

public class CreatedBaggageDeliveryOrderScreen {
    public Button cancelOrderButton = new Button(AppiumBy.xpath(""), "Отменить");
    public Button editOrderButton = new Button(AppiumBy.xpath(""), "Редактировать");
    public Button photoFixationOrderButton = new Button(AppiumBy.xpath(""), "Фотофиксация");
    public Button subscribeOrderButton = new Button(AppiumBy.xpath(""), "Подписать");
}
