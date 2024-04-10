package elements.menu;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static screens.BaseScreen.menu;

public class Menu {
    public Button openMenuButton = new Button(
            AppiumBy.xpath("(//android.widget.Button[@resource-id=\"RNE__ICON__CONTAINER_ACTION\"])[1]"),
            "Открыть меню");

    @Step("Перейти на экран \"{menuSection}\"")
    public void openMenuSection(MenuSections menuSection) {
        openMenuButton.buttonTap();
        $(AppiumBy.xpath("//android.widget.TextView[@text='" + menuSection.getName() + "']/parent::*"))
                .click(tap());
    }

    @Step("Открыть личный кабинет")
    public void openPersonalCabinet(){
        menu.openMenuButton.buttonTap();
        $(AppiumBy.xpath("//android.widget.TextView[@text=\"Диспетчер\"]/parent::*/parent::*"))
                .click(tap());
    }
}
