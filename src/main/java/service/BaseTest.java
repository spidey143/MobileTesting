package service;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.*;
import screens.base.BaseScreen;
import steps.Steps;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class BaseTest extends Driver implements BaseScreen, Steps {

    private final AppiumDriverLocalService APPIUM_SERVICE = new AppiumServiceBuilder()
            .usingPort(4723).withArgument(() -> "--allow-insecure","chromedriver_autodownload").build();

    @BeforeSuite(description = "Инициализация")
    public void init() {
        APPIUM_SERVICE.start();
        Configuration.browser = Driver.class.getName();
    }

    @BeforeMethod(description = "Октрытие приложения")
    public void setUp() {
        SelenideAppium.launchApp();
        mainScreen.testEnvironmentActivate();
    }

    @Step("Aвторизация в системе")
    public void login() {
        mainScreen.loginButton.buttonTap();
        if (SelenideAppium.$(AppiumBy.id("com.android.chrome:id/control_container"))
                .shouldBe(Condition.visible).isDisplayed()){
            SelenideAppium.switchTo().context("WEBVIEW_chrome");
            authScreen.usernameField.setValue(CONFIG.getUsername());
            authScreen.passwordField.setValue(CONFIG.getPassword());
            authScreen.loginButton.buttonClick();
            SelenideAppium.switchTo().context("NATIVE_APP");
        }
        else if (requestsScreen.createRequestButton.isVisibility()){
            requestsScreen.dismissUpdateNotification();
        }
        requestsScreen.dismissUpdateNotification();
    }

    @Step("Выход из системы")
    public void logout(){
        while(!$(AppiumBy.xpath("//android.widget.TextView[@text='Заявки']")).isDisplayed())
            SelenideAppium.back();
        menu.openPersonalCabinet();
        personalCabinetScreen.exitButton.buttonTap();
        Assert.assertTrue(mainScreen.loginButton.isVisibility(), "Выход из акканунта не произошел!");
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
