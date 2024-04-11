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
    public SelectForm numberVs = new SelectForm("Номер ВС");
    public TextField flightNumber = new TextField("Номер рейса");
    public SelectForm typeVs = new SelectForm("Тип ВС");;
    public DatePicker startPlanDp = new DatePicker("Начало (план)*");
    public TimePicker starPlanTp = new TimePicker("Начало (план)*");
    public DatePicker endPlanDp = new DatePicker("Окончание (план)");
    public TimePicker endPlanTp = new TimePicker("Окончание (план)");
    private SelenideElement planTotalDuration; //ПОКА ПОх
    private SelenideElement closeCheckBox; //ПОКА ПОх
    public SelectForm platform = new SelectForm("Перрон*");
    public SelectForm parkingPlace = new SelectForm("Место стоянки");
    public SelectForm jobView = new SelectForm("Вид Работы*");
    public TextField count = new TextField("Количество");
    public TextField comment =  new TextField("Комментарий");
    public TextField additionalInfo =  new TextField("Дополнительная информация / WO");
    public Button addDocumentButton = new Button(AppiumBy.xpath(""),"Добавление документа");
    public Button cancelButton = new Button(
            AppiumBy.xpath("//android.widget.TextView[@text=\"Отменить\"]/.."),
            "Отменить");
    public Button createRequestButton = new Button(
            AppiumBy.xpath("//android.widget.TextView[@text=\"Создать заявку\"]/.."),
            "Создать заявку");
}
