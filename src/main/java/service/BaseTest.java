package service;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import screens.BaseScreen;
import screens.RequestsScreen;

public class BaseTest implements BaseScreen {

    private final AppiumServiceBuilder APPIUM_SERVICE_BUILDER = new AppiumServiceBuilder()
            .usingPort(4723).withArgument(() -> "--allow-insecure","chromedriver_autodownload");

    @BeforeClass(description = "Инициализация")
    public void init() {
        APPIUM_SERVICE_BUILDER.build().start(); // запуск appium
        Configuration.browser = Driver.class.getName();
    }

    //@Step("Aвторизация")
    public void login() {
        if (mainScreen.loginButton.isVisibility()) {
            mainScreen.loginButton.buttonTap();
        }
        SelenideAppium.switchTo().context("WEBVIEW_chrome");
        authScreen.usernameField.setValue("ODispatcher");
        authScreen.passwordField.setValue("12345");
        authScreen.loginButton.buttonClick();

        SelenideAppium.switchTo().context("NATIVE_APP");
        if (requestsScreen.updateButton.isVisibilityAfter()) SelenideAppium.back();
    }

    @BeforeMethod(description = "Октрытие приложения")
    public void setUp() {
        SelenideAppium.launchApp();
        //com.bap_mobile.utg:id/action_bar_root
    }
    @AfterMethod(description = "Закрытие приложения")
    public void tearDown() {
        WebDriverRunner.driver().close();
    }

    @AfterClass(description = "Остановка appium")
    public void closeAppium() {
        APPIUM_SERVICE_BUILDER.build().stop();
    }
}
