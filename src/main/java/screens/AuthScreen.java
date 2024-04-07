package screens;
import elements.Button;
import elements.TextField;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class AuthScreen {
    public TextField usernameField = new TextField(By.id("username"), "Текстовое поле 'Логин'");
    public TextField passwordField = new TextField(By.id("password"), "Текстовое поле 'Пароль'");
    public Button loginButton = new Button(By.id("kc-login"), "Кнопка 'Вход'");
}
