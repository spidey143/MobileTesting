package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;
import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class BaseElement {
    protected SelenideElement element;

    public BaseElement(By by) {
        this.element = $(by);
    }

    protected BaseElement(By by, String name) {
        this.element = $(by).as(name);
    }

    public boolean isVisibility() {
        return element.is(Condition.visible);
    }

    public String getText() {
        return element.text();
    }

    public String getValue() {
        return element.getValue();
    }

    public Boolean isEnabled() {
        return element.is(Condition.enabled);
    }

    public String getAttribute(String attribute) {
        return element.getAttribute(attribute);
    }

    public String getCssValue(String value) {
        return element.getCssValue(value);
    }
}
