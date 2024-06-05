package elements.menu;

import elements.base.Button;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static screens.base.BaseScreen.MENU;

public class Menu {
    public Button openMenuButton = new Button(
            AppiumBy.xpath("(//android.widget.Button[@resource-id=\"RNE__ICON__CONTAINER_ACTION\"])[1]"),
            "Открыть меню");

    @Step("Перейти на экран \"{menuSection.name}\"")
    public void openMenuSection(MenuSections menuSection) {
        openMenuButton.buttonTap();
        $(AppiumBy.xpath("//android.widget.TextView[@text='" + menuSection.getName() + "']/parent::*"))
                .click(tap());
    }
    public void openPersonalCabinet(){
        MENU.openMenuButton.buttonTap();
        $(AppiumBy.xpath("//android.widget.TextView[@text=\"Диспетчер\"]/parent::*/parent::*"))
                .click(tap());
    }
}
