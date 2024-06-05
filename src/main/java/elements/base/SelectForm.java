package elements.base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;

public class SelectForm extends BaseElement {
    public Button applyButton = new Button(
            AppiumBy.xpath("//android.widget.TextView[@text=\"Применить\"]/.."),
            "Применить");
    private String nameForOpen;
    private SelenideElement title;
    private SelenideElement search;

    public SelectForm(String name) {
        super(AppiumBy.xpath("//android.widget.TextView[@text='" + name + "']/parent::*"),
                "Форма выбора поля: {'" + name + "'}");
        this.nameForOpen = name;
        this.search = $(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"RNE__SearchBar\"]"))
                .as("Поиск");
        this.title = $(AppiumBy.xpath("//android.widget.TextView[@text='" + name + "']"))
                .as("Заголовок формы");
    }

    @Step("Выбрать пункт: {itemName}")
    public void selectItem(String itemName) {
        SelenideElement item = $(AppiumBy.xpath("(//android.widget.ScrollView)[2]//android.widget.CheckBox/android.widget.TextView[@text='" + itemName + "']"));
        if (!item.isDisplayed()) {
            if (search.isDisplayed()) {
                search.setValue(itemName);
                item.shouldBe(Condition.visible).click(tap());
            } else {
                SelenideElement openFormButton = Selenide.$(AppiumBy.xpath("//android.widget.TextView[@text='" + nameForOpen + "']/..//android.widget.TextView[@text=\"Выберите\"]/..//android.widget.Button"));
                openFormButton.shouldBe(Condition.visible).click(tap());
            }
        } else {
            item.shouldBe(Condition.visible).click(tap());
        }
        this.applyButton.buttonTap();
        Assert.assertTrue(checkValueIsSet(itemName), "Значение не было установлено!");
    }

    @Step("Проерить что значение {value} установлено в поле {this.nameForOpen}")
    public boolean checkValueIsSet(String value) {
        return Selenide.$(AppiumBy.xpath("//android.widget.TextView[@text='" + nameForOpen + "']/..//android.widget.TextView[@text='" + value + "']"))
                .shouldBe(Condition.visible)
                .isDisplayed();
    }

    @Step("Открыть форму выбора поля: {this.nameForOpen}")
    public SelectForm openForm() {
        SelenideElement openFormButton = Selenide.$(AppiumBy.xpath("//android.widget.TextView[@text='" + nameForOpen + "']/..//android.widget.TextView[@text=\"Выберите\"]/..//android.widget.Button"));
        openFormButton.shouldBe(Condition.visible).click(tap());
        Assert.assertTrue(formIsOpened());
        return this;
    }

    @Step("Проверить, что форма открылась")
    public boolean formIsOpened() {
        return this.title.isDisplayed();
    }
}
