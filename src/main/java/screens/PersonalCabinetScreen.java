package screens;

import com.beust.ah.A;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;


@Getter
public class PersonalCabinetScreen {
    private SelenideElement textSize = $(AppiumBy.xpath("//android.widget.TextView[@text=\"Размер текста\"]"));
    private SelenideElement updatePO = $(AppiumBy.xpath("//android.widget.TextView[@text=\"Обновление ПО\"]"));
    private SelenideElement turnOnDarkTheme = $(AppiumBy.xpath("//android.widget.TextView[@text=\"Включить тёмную тему\"]"));
    private SelenideElement exitButton = $(AppiumBy.xpath("//android.widget.TextView[@text=\"Выйти\"]"));
}
