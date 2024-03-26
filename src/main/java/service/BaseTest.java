package service;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass(description = "Инициализация")
    public void setUp(){
        Configuration.browser = Driver.class.getName();
        SelenideAppium.launchApp();
    };

    @AfterClass(description = "Завершение")
    public void tearDown(){
        Driver.closeDriver();
    };
}
