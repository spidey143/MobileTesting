package screens;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.base.Button;
import elements.base.TextField;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AuthScreen {
    public TextField usernameField = new TextField(By.xpath("//input[@name=\"username\"]"), "Логин");
    public TextField passwordField = new TextField(By.xpath("//input[@name=\"password\"]"), "Пароль");
    public Button loginButton = new Button(By.xpath("//input[@name=\"login\"]"), "Вход");
    private final SelenideElement ERROR_MESSAGE = $(AppiumBy.xpath("//span[@id=\"input-error\"]")).as("Ошибка о неверном логине/пароле");

    @Step("Проверить что появляется уведомление о неверном логине/пароле")
    public boolean checkErrorMessage(){
        return ERROR_MESSAGE.shouldBe(Condition.visible).isDisplayed();
    }
}
