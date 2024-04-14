package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.*;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;

public class SelectForm extends BaseElement {
    public Button closeFormButton;
    public Button resetButton = new Button(
            AppiumBy.xpath("//android.widget.TextView[@text=\"Сбросить\"]/.."),
            "Сбросить");;
    public Button applyButton = new Button(
            AppiumBy.xpath("//android.widget.TextView[@text=\"Применить\"]/.."),
            "Применить");
    private String nameForOpen;
    private SelenideElement title;
    private SelenideElement search;
    //private ElementsCollection items = $$(AppiumBy.xpath("(//android.widget.ScrollView)[2]//android.widget.CheckBox/android.widget.TextView"))
    // .as("Список доступных значений");

    public SelectForm(String name) {
        super(AppiumBy.xpath("//android.widget.TextView[@text='" + name + "']/parent::*"),
                "Форма выбора поля: {'" + name + "'}");
        this.nameForOpen = name;
        this.title = $(AppiumBy.xpath("//android.widget.TextView[@text='" + name + "']"))
                .as("Заголовок формы");
    }

    @Step("Выбрать пункт: {itemName}")
    public void selectItem(String itemName) {
        $(AppiumBy.xpath("(//android.widget.ScrollView)[2]//android.widget.CheckBox/android.widget.TextView[@text='" + itemName + "']"))
                .shouldBe(Condition.visible)
                .click(tap());
        this.applyButton.buttonTap();
    }

    @Step("Открыть форму выбора поля: {this.nameForOpen}")
    public SelectForm openForm() {
        SelenideAppium.$(AppiumBy.xpath("//android.widget.TextView[@text='" + nameForOpen + "']/..//android.widget.TextView[@text=\"Выберите\"]/..//android.widget.Button"))
                .shouldBe(Condition.visible)
                .click(tap());

        /*SelenideAppium.$(AppiumBy.xpath("//android.widget.TextView[@text='" + nameForOpen + "']/../android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"))
                .shouldHave(Condition.text("Выберите"))
                .ancestor("")
                .find(AppiumBy.xpath(".//android.widget.Button"))
                .click(tap());*/
        Assert.assertTrue(formIsOpened());
        return this;
    }

    @Step("Проверить, что форма открылась")
    public boolean formIsOpened() {
        return this.title.isDisplayed();
    }
}
