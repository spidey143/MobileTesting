package screens.requests;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.SelectForm;
import elements.TextField;
import elements.pickers.DatePicker;
import elements.pickers.TimePicker;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CreateRequestScreen {
    public SelectForm service = new SelectForm("Услуга*");
    public SelectForm customer = new SelectForm("Заказчик*");
    public SelectForm airline = new SelectForm("Авиакомпания*");
    public SelectForm operator = new SelectForm("Оператор*");
    public SelectForm office = new SelectForm("Офис*");
    public SelectForm numberVs = new SelectForm("Номера ВС");
    public TextField flightNumber = new TextField(
            AppiumBy.xpath(""), "Номер рейса");
    public SelectForm typeVs = new SelectForm("Тип ВС");;
    public DatePicker startPlanDp = new DatePicker();
    public TimePicker starPlanTp = new TimePicker();
    public DatePicker endPlanDp = new DatePicker();
    public TimePicker endPlanTp = new TimePicker();
    private SelenideElement planTotalDuration; //ПОКА ПОх
    private SelenideElement closeCheckBox; //ПОКА ПОх
    public SelectForm platform = new SelectForm("Перрон*");
    public SelectForm parkingPlace = new SelectForm("Место стоянки");
    public SelectForm jobView = new SelectForm("Вид Работы*");
    public TextField count = new TextField(AppiumBy.xpath(""),"Количество");
    public TextField comment =  new TextField(AppiumBy.xpath(""),"Комментарий");
    public TextField additionalInfo =  new TextField(AppiumBy.xpath(""),"Дополнительная информация / WO");
    public Button addDocumentButton = new Button(AppiumBy.xpath(""),"Добавление документа");
    public Button cancelButton = new Button(
            AppiumBy.xpath("//android.widget.TextView[@text=\"Отменить\"]/.."),
            "Отменить");
    public Button createRequestButton = new Button(
            AppiumBy.xpath("//android.widget.TextView[@text=\"Создать заявку\"]/.."),
            "Создать заявку");
}
