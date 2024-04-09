package elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SelectForm extends BaseElement{
    private String name;
    private SelenideElement title;
    private SelenideElement search;
    private ElementsCollection items;
    public Button resetButton;
    public Button applyButton;

    public SelectForm(By by, String name) {
        super(by, "Форма выбора поля: {'" + name + "'}");
        title = $(AppiumBy.xpath("")).as("Заголовок формы"); //TODO: добавить локатор
        search = $(AppiumBy.xpath("")).as("Поиск"); //TODO: добавить локатор
        items = $$(AppiumBy.xpath("")).as("Список доступных значений"); //TODO: добавить локатор
        applyButton = new Button(By.xpath("//button[text()='Apply']"), name); //TODO: добавить локатор
        resetButton = new Button(By.xpath("//button[text()='Reset']"), name); //TODO: добавить локатор
    }
}
