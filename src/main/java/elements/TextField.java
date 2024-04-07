package elements;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

public class TextField extends BaseElement{
    public TextField(By by, String name) {
        super(by, name);
    }

    public void setValue(String value){
        element.shouldBe(Condition.visible).setValue(value);
    }
}
