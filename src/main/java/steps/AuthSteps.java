package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.testng.Assert;
import screens.base.BaseScreen;

import static com.codeborne.selenide.Selenide.$;

public class AuthSteps implements BaseScreen {
    @Step("Aвторизация в системе")
    public void login(String username, String password) {
        MAIN_SCREEN.loginButton.buttonTap();
        if (SelenideAppium.$(AppiumBy.id("com.android.chrome:id/control_container")).isDisplayed()) {
            SelenideAppium.switchTo().context("WEBVIEW_chrome");
            AUTH_SCREEN.usernameField.setValue(username);
            AUTH_SCREEN.passwordField.setValue(password);
            AUTH_SCREEN.loginButton.buttonClick();
            SelenideAppium.switchTo().context("NATIVE_APP");
            Assert.assertTrue($(AppiumBy.xpath("//android.widget.TextView[@text=\"Заявки PA\"]")).isDisplayed(), "Ошибка авторизации!");
        }
        REQUESTS_SCREEN.dismissUpdateNotification();
    }

    @Step("Выход из системы")
    public void logout() {
        while (!$(AppiumBy.xpath("//android.widget.TextView[@text=\"Заявки\"]")).isDisplayed()) {
            if($(AppiumBy.xpath("//android.widget.TextView[@text=\"Заявки PA\"]")).isDisplayed())
                break;
            SelenideAppium.back();
        }
        MENU.openPersonalCabinet();
        PERSONAL_CABINET_SCREEN.exitButton.buttonTap();
        Assert.assertTrue(MAIN_SCREEN.loginButton.isVisibility(), "Выход из акканунта не произошел!");
    }
}
