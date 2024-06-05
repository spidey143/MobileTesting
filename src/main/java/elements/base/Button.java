package elements.base;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.appium.AppiumClickOptions.tap;

public class Button extends BaseElement {
    public Button(String text, String name) {
        super(AppiumBy.xpath("//android.widget.Button[@text='" + text + "']"),
                "Кнопка: {'" + name + "'}");
    }

    public Button(By by, String name) {
        super(by, "Кнопка: {'" + name + "'}");
    }

    public void buttonTap() {element.shouldBe(Condition.visible).click(tap());}

    public void buttonClick() {
        element.shouldBe(Condition.visible).click();
    }
}
