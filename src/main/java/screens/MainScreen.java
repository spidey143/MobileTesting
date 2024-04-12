package screens;
import elements.Button;
import io.appium.java_client.AppiumBy;

public class MainScreen {
    public Button loginButton = new Button(AppiumBy.xpath("//android.widget.Button"), "Войти");
}
