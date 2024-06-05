package screens;

import com.codeborne.selenide.SelenideElement;
import elements.base.Button;
import elements.base.SelectForm;
import elements.base.TextField;
import elements.pickers.DatePicker;
import elements.pickers.TimePicker;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class CreateRequestScreen {
    public SelectForm service = new SelectForm("Услуга*");
    public SelectForm customer = new SelectForm("Заказчик*");
    public SelectForm numberVs = new SelectForm("Номер ВС");
    public TextField flightNumber = new TextField("Номер рейса");
    public SelectForm typeVs = new SelectForm("Тип ВС");;
    public DatePicker startPlanDp = new DatePicker("Начало (план)*");
    public TimePicker starPlanTp = new TimePicker("Начало (план)*");
    public DatePicker endPlanDp = new DatePicker("Окончание (план)");
    public TimePicker endPlanTp = new TimePicker("Окончание (план)");
    public SelectForm platform = new SelectForm("Перрон*");
    public SelectForm parkingPlace = new SelectForm("Место стоянки");
    public SelectForm jobView = new SelectForm("Вид работы*");
    public TextField count = new TextField("Количество*");
    public TextField comment =  new TextField("Комментарий");
    public TextField additionalInfo =  new TextField("Дополнительная информация / WO");
    public Button createRequestButton = new Button(
            AppiumBy.xpath("//android.widget.TextView[@text=\"Создать заявку\"]"),
            "Создать заявку");

}
