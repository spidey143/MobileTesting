package screens.requests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppium;
import elements.Button;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import screens.BaseScreen;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class RequestsScreen implements BaseScreen {
    private SelenideElement updateNotification = $(AppiumBy.xpath("//android.widget.TextView[contains(@text, \"Необходимо обновить приложение\")]"));

    public Button createRequestButton = new Button(
            AppiumBy.xpath("//android.widget.TextView[@text=\"\uE145\"]//ancestor::android.widget.Button[1]"),
            "Cоздание заявки");

    @Step("Убрать всплывающее уведомление об обновлении приложения")
    public void dismissUpdateNotification() {
        if (updateNotification.shouldBe(Condition.visible, Duration.ofSeconds(10)).is(Condition.visible))
            SelenideAppium.back();
    }
}
