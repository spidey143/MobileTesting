package screens.requests;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class CreateRequestScreen {
    public Button cancelButton = new Button(
            AppiumBy.xpath("//android.widget.TextView[@text=\"Отменить\"]/.."),
            "Кнопка 'Отменить'");
    public Button createRequestButton = new Button(
            AppiumBy.xpath("//android.widget.TextView[@text=\"Создать заявку\"]/.."),
            "Кнопка 'Создать заявку'");
    public SelenideElement service;
    public SelenideElement customer;
    public SelenideElement airline;
    public SelenideElement operator;
    public SelenideElement office;
    public SelenideElement numberVs;
    public SelenideElement flightNumber;
    public SelenideElement typeVs;
    public SelenideElement startPlan;
    public SelenideElement endPlan;
    public SelenideElement planTotalDuration;
    public SelenideElement executor;
    public SelenideElement garageNumberSpecialEquipment;
}
