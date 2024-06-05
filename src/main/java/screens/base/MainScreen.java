package screens.base;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.AppiumScrollOptions;
import com.codeborne.selenide.appium.SelenideAppium;
import elements.base.Button;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainScreen {
    public Button loginButton = new Button(AppiumBy.xpath("//android.widget.Button"), "Войти");
    private SelenideElement versionApp = $(AppiumBy.xpath("//android.widget.TextView[contains(@text,'Версия')]"));
    private SelenideElement settingEnvironment = $(AppiumBy.xpath("//android.widget.TextView[@text=\"Настройки окружения\"]/../android.view.ViewGroup[1]"));
    public void testEnvironmentActivate(){
        for (int i = 0; i < 5; i++) {
            versionApp.shouldBe(Condition.visible).click();
        }
        settingEnvironment.findElement(By.xpath("//android.widget.Button")).click();
        $(AppiumBy.xpath("//android.widget.TextView[@text=\"Test UTG\"]")).click();
        $(AppiumBy.xpath("//android.widget.TextView[@text=\"Применить\"]/..")).click();
        SelenideAppium.$(AppiumBy.xpath("//android.widget.TextView[@text=\"Сохранить конфиг\"]/.."))
                .scroll(AppiumScrollOptions.down())
                .click();
    }
}
