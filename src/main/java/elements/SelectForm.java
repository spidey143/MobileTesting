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

public class SelectForm extends BaseElement {
    public Button closeFormButton;
    public Button resetButton;
    public Button applyButton;
    private String nameForOpen;
    private SelenideElement title;
    private SelenideElement search;
    private ElementsCollection items;

    public SelectForm(String name) {
        super(AppiumBy.xpath("//android.widget.TextView[@text='" + name + "']/.."),
                "Форма выбора поля: {'" + name + "'}");
        this.nameForOpen = name;
        this.closeFormButton = new Button(AppiumBy.xpath(
                "//android.widget.TextView[@text='" + name + "']" +
                        "/../android.view.ViewGroup[1]//android.widget.Button"),
                "Закрыть");
        this.title = $(AppiumBy.xpath("//android.widget.TextView[@text='" + name + "']"))
                .as("Заголовок формы");
        this.search = $(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"RNE__SearchBar\"]"))
                .as("Поиск");
        this.items = $$(AppiumBy.xpath("(//android.widget.ScrollView)[2]//android.widget.CheckBox/android.widget.TextView"))
                .as("Список доступных значений");
        this.applyButton = new Button(By.xpath("//android.widget.TextView[@text=\"Применить\"]/.."),
                "Применить");
        this.resetButton = new Button(By.xpath("//android.widget.TextView[@text=\"Сбросить\"]/.."),
                "Сбросить");
    }

    @Step("Выбрать пункт: {itemName}")
    public void selectItem(String itemName) {
        SelenideElement foundItem = this.items.find(Condition.text(itemName));
        if (foundItem.isDisplayed()) {
            if (!foundItem.isSelected()) foundItem.click(tap());
        } else {
            search.setValue(itemName);
            foundItem.click(tap());
        }
        this.applyButton.buttonTap();
    }

    @Step("Открыть форму выбора поля {fieldName}")
    public SelectForm open() {
        $(AppiumBy.xpath("//android.widget.TextView[@text='" + this.nameForOpen + "']/.." +
                "//android.widget.Button"))
                .click();
        return this;
    }
}
