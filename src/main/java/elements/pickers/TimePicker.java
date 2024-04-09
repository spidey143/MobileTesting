package elements.pickers;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.TextField;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class TimePicker {
    public Button toggleModeToKeyboardButton;
    public TextField minutesInputField;
    public TextField hourInputField;
    public Button cancelButton;
    public Button okButton;

    public TimePicker() {
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
        String hour = rTime[0];
        String minutes = rTime[1];
        toggleModeToKeyboardButton.buttonTap();
        hourInputField.setValue(hour);
        minutesInputField.setValue(minutes);
        okButton.buttonClick();
    }
}
