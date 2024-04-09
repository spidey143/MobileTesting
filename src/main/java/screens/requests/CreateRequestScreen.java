package screens.requests;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.pickers.DatePicker;
import elements.pickers.TimePicker;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class CreateRequestScreen {
    public SelenideElement service;
    public SelenideElement customer;
    public SelenideElement airline;
    public SelenideElement operator;
    public SelenideElement office;
    public SelenideElement numberVs;
    public SelenideElement flightNumber;
    public SelenideElement typeVs;
    public DatePicker startPlanDp;
    public TimePicker starPlanTp;
    public DatePicker endPlanDp;
    public TimePicker endPlanTp;
    public SelenideElement planTotalDuration;
    public SelenideElement closeCheckBox;
    public SelenideElement platform;
    public SelenideElement parkingPlace;
    public SelenideElement count;
    public SelenideElement comment;
    public Button addDocumentButton = new Button(
            AppiumBy.xpath(""),
            "Добавление документа");
    public Button cancelButton = new Button(
            AppiumBy.xpath("//android.widget.TextView[@text=\"Отменить\"]/.."),
            "Отменить");
    public Button createRequestButton = new Button(
            AppiumBy.xpath("//android.widget.TextView[@text=\"Создать заявку\"]/.."),
            "Создать заявку");
}
