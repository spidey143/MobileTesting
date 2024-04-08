package elements.menu;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;

public class Menu {
    public Button openMenuButton = new Button(
            AppiumBy.xpath("(//android.widget.Button[@resource-id=\"RNE__ICON__CONTAINER_ACTION\"])[1]"),
            "Кнопка для открытия Меню");

    @Step("Открыть страницу \"{menuSection}\"")
    public void openMenuSection(MenuSections menuSection) {
        openMenuButton.buttonTap();
        $(AppiumBy.xpath("//android.widget.TextView[@text='" + menuSection.getName() + "']"))
                .$(AppiumBy.xpath("/..")).click(tap());
    }

    @Step("Открыть личный кабинет")
    public void openPersonalCabinet(){
        $(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"listItemTitle\" and @text=\"Диспетчер\"]"))
                .$(AppiumBy.xpath("/../..")).click(tap());
    }
}
