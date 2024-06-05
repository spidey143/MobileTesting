package screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppium;
import elements.base.Button;
import elements.base.ModalWindow;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import lombok.Getter;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;

public class CreatedRequestScreen {
    public Button chatButton = new Button(
            AppiumBy.xpath("(//android.widget.Button[@resource-id=\"RNE__ICON__CONTAINER_ACTION\"])[3]"),
            "Чат");
    public Button cancelRequestButton = new Button(
            AppiumBy.xpath("//android.widget.TextView[@text=\"Отменить\"]/.."),
            "Отменить заявку");
    public Button refusalServiceButton = new Button(
            AppiumBy.xpath("//android.widget.TextView[@text=\"Отказ\"]/.."),
            "Отказ от услуги");
    public Button editRequestButton = new Button(
            AppiumBy.xpath("//android.widget.TextView[@text=\"Редактировать\"]/.."),
            "Редактировать");
    public ModalWindow cancelRequestModalWindow = new ModalWindow("Подтверждение отмены заявки");
    public ModalWindow refusalRequestModalWindow = new ModalWindow("Подтверждение отказа от заявки");
    private SelenideElement requestActionsPanel = SelenideAppium.$(AppiumBy.xpath("//android.widget.SeekBar[@content-desc=\"Bottom Sheet\"]/..//android.view.ViewGroup[2]"));
    private SelenideElement requestIsRefused = $(AppiumBy.xpath("//android.widget.TextView[@text=\"Отказ:\"]"));
    @Getter
    private int fieldsSize;
    @Step("Проверить что заявка создана")
    public void checkRequestIsCreated() {
        Assert.assertTrue(requestActionsPanel.shouldBe(Condition.visible).isDisplayed(), "Ошибка в создании заявки!");
        fieldsSize = $$(AppiumBy.xpath("(//android.widget.ScrollView)[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")).size();
    }

    @Step("Проверить что заявка отменена")
    public void checkRequestIsCancelled() {
        openRequestActionsPanel();
        Assert.assertFalse(cancelRequestButton.isVisibility(), "Ошибка в создании заявки!");
    }

    public void openRequestActionsPanel() {
        requestActionsPanel.click(tap());
    }

    @Step("Проверить что заявка отредактировалась успешно")
    public void checkRequestIsEdited(int fieldsSizeBeforeEdit)  {
        requestActionsPanel.shouldBe(Condition.visible);
        fieldsSize = $$(AppiumBy.xpath("(//android.widget.ScrollView)[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")).size();
        Assert.assertNotEquals(fieldsSizeBeforeEdit, fieldsSize,  "Ошибка в редактирование заявки!");
    }

    @Step("Проверить что произошел отказ от заявки")
    public void checkRequestIsRefused() {
        Assert.assertTrue(requestIsRefused.shouldBe(Condition.visible).isDisplayed(), "Отказ от заявки не произошел!");
    }
}
