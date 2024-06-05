package elements.pickers;

import com.codeborne.selenide.Condition;
import elements.base.BaseElement;
import elements.base.Button;
import elements.base.TextField;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;

public class TimePicker extends BaseElement {
    public Button toggleModeToKeyboardButton;
    public TextField minutesInputField;
    public TextField hourInputField;
    public Button cancelButton;
    public Button okButton;

    public TimePicker(String name) {
        super(AppiumBy.id("android:id/timePicker"), "тайм пикер поля" + name);
        toggleModeToKeyboardButton = new Button(
                AppiumBy.xpath("//android.widget.ImageButton"),
                "Переход в режим ввода текста"
        );
        hourInputField = new TextField(
                By.id("android:id/input_hour"),
                "Ввод часов"
        );
        minutesInputField = new TextField(
                By.id("android:id/input_minute"),
                "Ввод минут"
        );
        cancelButton = new Button("ОТМЕНА", "Отменить выбора даты");
        okButton = new Button("ОК", "Подтвердить выбора даты");
    }

    @Step("Установить время {time}")
    public void setTime(String time){
        String[] rTime = time.split(":");
        String hours = rTime[0];
        String minutes = rTime[1];
        toggleModeToKeyboardButton.buttonTap();
        hourInputField.setValue(hours);
        minutesInputField.setValue(minutes);
        okButton.buttonClick();
    }
}
