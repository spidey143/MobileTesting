package elements.pickers;

import com.beust.ah.A;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.AppiumScrollOptions;
import com.codeborne.selenide.appium.ScrollDirection;
import com.codeborne.selenide.appium.SelenideAppium;
import elements.Button;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;

public class DatePicker {
    public Button cancelButton;
    public Button okButton;
    private SelenideElement currentYear;
    private SelenideElement currentMonth;
    public Button prevMonthButton;
    public Button nextMonthButton;

    public DatePicker() {
        currentYear = $(AppiumBy.id("android:id/date_picker_header_year"));
        prevMonthButton = new Button(
                AppiumBy.id("android:id/prev"),
                "Кнопка для смены текущего месяца на предыдущий");
        nextMonthButton = new Button(
                AppiumBy.id("android:id/next"),
                "Кнопка для смены текущего месяца на следующий");
        okButton = new Button("ОК", "Подтвердить выбора даты");
        cancelButton = new Button("ОТМЕНА", "Отменить выбора даты");
    }

    @Step("Установить дату {date}")
    public void setDate(String date){
        String[] rDate = date.split("\\.");
        String day = rDate[0];
        String month = rDate[1];
        String year = rDate[2];
        if (!currentYear.getText().equals(year)){
            currentYear.click(tap());
            if(Integer.parseInt(currentYear.getText()) < Integer.parseInt(year)){
                SelenideAppium.$(AppiumBy.xpath("//android.widget.TextView[@text='"+year+"']"))
                        .scroll(AppiumScrollOptions.with(
                                ScrollDirection.UP,
                                Integer.parseInt(year) - Integer.parseInt(currentYear.getText())
                                )
                        );
            }
            SelenideAppium.$(AppiumBy.xpath("//android.widget.TextView[@text='"+year+"']"))
                    .scroll(AppiumScrollOptions.with(
                                    ScrollDirection.DOWN,
                                    Integer.parseInt(currentYear.getText()) - Integer.parseInt(year)
                            )
                    );
        }
        $$(AppiumBy.xpath(
                "//android.view.View[@resource-id=\"android:id/month_view\"]//android.view.View"))
                .find(Condition.text(day))
                .click(tap());
        okButton.buttonTap();
    }
}
