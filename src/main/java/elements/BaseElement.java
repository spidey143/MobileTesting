package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;
import com.codeborne.selenide.appium.AppiumScrollOptions;
import com.codeborne.selenide.appium.ScrollDirection;
import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class BaseElement {
    protected SelenideAppiumElement element;

    public BaseElement(By by) {
        this.element = SelenideAppium.$(by);
    }

    protected BaseElement(By by, String name) {
        this.element = (SelenideAppiumElement) SelenideAppium.$(by).as(name);
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

    public void scrollTo() {
        element.scroll(AppiumScrollOptions.down());
    }
}
