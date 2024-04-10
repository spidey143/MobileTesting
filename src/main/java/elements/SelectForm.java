package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;

public class SelectForm extends BaseElement{
    private String nameForOpen;
    private SelenideElement title;
    private SelenideElement search;
    private ElementsCollection items;
    public Button resetButton;
    public Button applyButton;

    public SelectForm(String name) {
        super(AppiumBy.xpath("//android.widget.TextView[@text='" + name + "']/parent::*"),
                "Форма выбора поля: {'" + name + "'}");
        this.nameForOpen = name;
        this.title = $(AppiumBy.xpath("")).as("Заголовок формы"); //TODO: добавить локатор
        this.search = $(AppiumBy.xpath("")).as("Поиск"); //TODO: добавить локатор
        this.items = $$(AppiumBy.xpath("")).as("Список доступных значений"); //TODO: добавить локатор
        this.applyButton = new Button(By.xpath("//button[text()='Apply']"), "Применить"); //TODO: добавить локатор
        this.resetButton = new Button(By.xpath("//button[text()='Reset']"), "Сбросить"); //TODO: добавить локатор
    }

    @Step("Выбрать пункт: {itemName}")
    public void selectItem(String itemName){
        this.items.find(Condition.text(itemName)).click(tap());
        this.applyButton.buttonTap();
    }

    @Step("Открыть форму выбора поля {fieldName}")
    public void openSelectForm(){
        $(AppiumBy.xpath("'" + this.nameForOpen + "'")).click(tap());
    }
}
