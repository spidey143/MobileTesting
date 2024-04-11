package elements.pickers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.AppiumScrollOptions;
import com.codeborne.selenide.appium.ScrollDirection;
import com.codeborne.selenide.appium.SelenideAppium;
import elements.BaseElement;
import elements.Button;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;

public class DatePicker extends BaseElement {
    public Button cancelButton;
    public Button okButton;
    public Button prevMonthButton;
    public Button nextMonthButton;
    private String nameForOpen;
    private SelenideElement currentYear;
    private SelenideElement currentMonth;

    public DatePicker(String name) {
        super(AppiumBy.id("android:id/datePicker"), "дейт пикер поля" + name);
        this.nameForOpen = name;
        this.currentYear = $(AppiumBy.id("android:id/date_picker_header_year"));
        this.prevMonthButton = new Button(
                AppiumBy.id("android:id/prev"),
                "Кнопка для смены текущего месяца на предыдущий");
        this.nextMonthButton = new Button(
                AppiumBy.id("android:id/next"),
                "Кнопка для смены текущего месяца на следующий");
        this.okButton = new Button("ОК", "Подтвердить выбора даты");
        this.cancelButton = new Button("ОТМЕНА", "Отменить выбора даты");
    }

    @Step("Установить дату {date}")
    public void setDate(String date) {
        String[] rDate = date.split("\\.");
        String day = rDate[0];
        String month = rDate[1];
        String year = rDate[2];
        if (!this.currentYear.getText().equals(year)) {
            this.currentYear.click(tap());
            if (Integer.parseInt(this.currentYear.getText()) < Integer.parseInt(year)) {
                SelenideAppium.$(AppiumBy.xpath("//android.widget.TextView[@text='" + year + "']"))
                        .scroll(AppiumScrollOptions.with(
                                        ScrollDirection.UP,
                                        Integer.parseInt(year) - Integer.parseInt(this.currentYear.getText())
                                )
                        );
            }
            SelenideAppium.$(AppiumBy.xpath("//android.widget.TextView[@text='" + year + "']"))
                    .scroll(AppiumScrollOptions.with(
                                    ScrollDirection.DOWN,
                                    Integer.parseInt(this.currentYear.getText()) - Integer.parseInt(year)
                            )
                    );
        }
        $$(AppiumBy.xpath(
                "//android.view.View[@resource-id=\"android:id/month_view\"]//android.view.View"))
                .find(Condition.text(day))
                .click(tap());
        this.okButton.buttonTap();
    }

    @Step("Открыть дейт пикер поля: {this.nameForOpen}")
    public DatePicker open() {
        $(AppiumBy.xpath("//android.widget.TextView[@text='" + this.nameForOpen + "']/.." +
                "//android.widget.Button"))
                .click();
        return this;
    }
}
