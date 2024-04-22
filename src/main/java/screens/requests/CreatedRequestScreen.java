package screens.requests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.ModalWindow;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

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
    public ModalWindow cancelRequestModalWindow = new ModalWindow("Подтверждение отмены заявки");
    public ModalWindow refusalRequestModalWindow = new ModalWindow("Подтверждение отказа от заявки");
}
