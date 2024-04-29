package screens;
import elements.base.Button;
import elements.base.TextField;
import org.openqa.selenium.By;

public class AuthScreen {
    public TextField usernameField = new TextField(By.id("username"), "Логин");
    public TextField passwordField = new TextField(By.id("password"), "Пароль");
    public Button loginButton = new Button(By.id("kc-login"), "Вход");
}
