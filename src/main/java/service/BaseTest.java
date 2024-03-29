package service;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeClass(description = "Настройка конфигурации")
    public void configuring(){
        Configuration.browser = Driver.class.getName();
    };

    @BeforeMethod(description = "Инициализация")
    public void setUp(){
        SelenideAppium.launchApp();
    }

    @AfterMethod(description = "Завершение")
    public void tearDown(){
        Driver.closeDriver();
    };
}
