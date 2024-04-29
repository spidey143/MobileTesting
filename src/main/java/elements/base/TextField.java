package elements.base;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class TextField extends BaseElement {
    private String name;
    public TextField(String name) {
        super(AppiumBy.xpath("//android.widget.TextView[@text='" + name + "']/..//android.widget.EditText"),
                "Текстовое поле: {'" + name + "'}");
        this.name = name;
    }
    public TextField(By by, String name) {
        super(by, "Текстовое поле: {'" + name + "'}");
        this.name = name;
    }

    @Step("Установить значение \"{value}\" в поле \"{this.name}\"")
    public void setValue(String value){
        element.shouldBe(Condition.visible).setValue(value);
    }
}
