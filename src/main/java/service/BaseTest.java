package service;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.*;
import screens.base.BaseScreen;

public class BaseTest extends Driver implements BaseScreen {

    private final AppiumDriverLocalService APPIUM_SERVICE = new AppiumServiceBuilder()
            .usingPort(4723).withArgument(() -> "--allow-insecure","chromedriver_autodownload").build();

    @BeforeSuite(description = "Инициализация")
    public void init() {
        APPIUM_SERVICE.start(); // запуск appium
        Configuration.browser = Driver.class.getName();
    }

    @Step("Aвторизация в системе")
    public void login() {
        if (mainScreen.loginButton.isVisibility()) {
            mainScreen.loginButton.buttonTap();
        }
        SelenideAppium.switchTo().context("WEBVIEW_chrome");

        authScreen.usernameField.setValue(CONFIG.getUsername());
        authScreen.passwordField.setValue(CONFIG.getPassword());
        authScreen.loginButton.buttonClick();

        SelenideAppium.switchTo().context("NATIVE_APP");
        requestsScreen.dismissUpdateNotification();
    }

    @Step("Выход из акканунта")
    public void logout(){
        menu.openPersonalCabinet();
        personalCabinetScreen.exitButton.buttonTap();
        Assert.assertTrue(mainScreen.loginButton.isVisibility(), "Выход из акканунта не произошел!");
    }

    @BeforeMethod(description = "Октрытие приложения")
    public void setUp() {
        SelenideAppium.launchApp();
    }
    @AfterMethod(description = "Закрытие приложения")
    public void tearDown() {
        Driver.closeApp();
    }

    @AfterSuite(description = "Остановка appium")
    public void closeAppium() {
        APPIUM_SERVICE.stop();
    }
}
