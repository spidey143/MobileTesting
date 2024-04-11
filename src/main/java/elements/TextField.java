package elements;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class TextField extends BaseElement{
    public TextField(String name) {
        super(AppiumBy.xpath("//android.widget.TextView[@text='" + name + "']/..//android.widget.EditText"),
                "Текстовое поле: {'" + name + "'}");
    }
    public TextField(By by, String name) {
        super(by, "Текстовое поле: {'" + name + "'}");
    }

    public void setValue(String value){
        element.shouldBe(Condition.visible).setValue(value);
    }
}
