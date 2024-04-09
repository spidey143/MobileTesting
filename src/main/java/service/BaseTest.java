package service;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.*;
import screens.BaseScreen;

import static com.codeborne.selenide.appium.AppiumClickOptions.tap;

public class BaseTest implements BaseScreen {

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
        authScreen.usernameField.setValue("ODispatcher");
        authScreen.passwordField.setValue("12345");
        authScreen.loginButton.buttonClick();

        SelenideAppium.switchTo().context("NATIVE_APP");
        if (requestsScreen.updateButton.isVisibilityAfter()) SelenideAppium.back();
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
        WebDriverRunner.driver().close();
    }

    @AfterSuite(description = "Остановка appium")
    public void closeAppium() {
        APPIUM_SERVICE.stop();
    }
}
