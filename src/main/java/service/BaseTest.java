package service;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import screens.base.BaseScreen;
import steps.Steps;

import static com.codeborne.selenide.Selenide.$;

public class BaseTest extends Driver implements BaseScreen, Steps {

    private final AppiumDriverLocalService APPIUM_SERVICE = new AppiumServiceBuilder()
            .usingPort(4723).withArgument(() -> "--allow-insecure", "chromedriver_autodownload").build();
    private final ProcessBuilder SCRCPY = new ProcessBuilder("src/main/resources/scrcpy-win32-v2.3.1/scrcpy-win32-v2.3.1/scrcpy.exe");

    @BeforeSuite(description = "Инициализация")
    public void init() {
        APPIUM_SERVICE.start();
        Configuration.browser = Driver.class.getName();
        try {
            SCRCPY.start();
        } catch (Exception e) {
            System.out.println("Приложение scrcpy не запущено");
        }
    }

    @BeforeMethod(description = "Октрытие приложения")
    public void setUp() {
        SelenideAppium.launchApp();
        MAIN_SCREEN.testEnvironmentActivate();
    }

    @AfterMethod(description = "Закрытие приложения")
    public void tearDown() {
        Driver.closeApp();
    }

    @AfterSuite(description = "Остановка appium", alwaysRun = true)
    public void closeAppium() {
        SCRCPY.command("taskkill /F /IM scrcpy.exe");
        APPIUM_SERVICE.stop();
    }
}
