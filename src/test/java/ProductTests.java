import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.appium.AppiumScrollOptions;
import com.codeborne.selenide.appium.ScrollDirection;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.BaseTest;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class ProductTests extends BaseTest {

    @Test(description = "Добавление товара в корзину")
    public void addProductToCart() {
        //Тапнуть на поле с поиском
        $(AppiumBy.id("ru.ozon.app.android:id/searchTv"))
                .hideKeyboard()
                .shouldBe(Condition.visible)
                .click(tap());

        //Ввести значение "iphone 15" в поле поиска
        $(AppiumBy.id("ru.ozon.app.android:id/etSearch"))
                .hideKeyboard()
                .shouldBe(Condition.visible)
                .setValue("iphone 15");

        //Тапнуть на предложенный вариант "iphone 15"
        $(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"iphone 15\"]"))
                .shouldBe(Condition.visible)
                .click(tap());

        /*Тапнуть на карточку с текстом
        * Apple Смартфон Смартфон Apple Iphone 15 128 ГБ китайской версии с дисплеем Super Retina XDR диагональю 6,1 дюйма
        *  и бионическим чипом 16 iOS 16 CN 6/128 ГБ, черный"
        * */
        String s = Selenide.$(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)" +
                        ".instance(0)).scrollIntoView(new UiSelector().textContains(\"Apple Iphone 15\").instance(0))")).getText();
        SelenideAppium.$(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)" +
                                ".instance(0)).scrollIntoView(new UiSelector().textContains(\"Apple Iphone 15\").instance(0))"))
                .scroll(AppiumScrollOptions.with(ScrollDirection.DOWN, 2))
                .click(tap());
        if(Selenide.$(AppiumBy.id("ru.ozon.app.android:id/onboardingV")).isDisplayed()) SelenideAppium.back();

        //Тапнуть на кнопку "В корзину"
        Selenide.$(AppiumBy.id("ru.ozon.app.android:id/mainBtn"))
                .shouldBe(Condition.visible)
                .click(tap());

        Selenide.$(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Корзина\"]"))
                .click(tap());

        //TODO поменять ассерт
        Assert.assertTrue(
                Selenide.$(AppiumBy.xpath("//android.widget.TextView[@text='"+s+"']"))
                        .isDisplayed(), "Товар не был добавлен в корзину"
        );
    }

    @Test(description = "Удаление товара из корзины")
    public void deleteProductOfCart() {
        //Тапнуть на поле с поиском
        Selenide.$(AppiumBy.id("ru.ozon.app.android:id/searchTv"))
                .shouldBe(Condition.visible)
                .click(tap());
        //Ввести значение "iphone 15" в поле поиска
        Selenide.$(AppiumBy.id("ru.ozon.app.android:id/etSearch"))
                .shouldBe(Condition.visible)
                .sendKeys("iphone 15");
        //Тапнуть на предложенный вариант "iphone 15"
        Selenide.$(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"iphone 15\"]"))
                .shouldBe(Condition.visible)
                .click(tap());
        //Тапнуть на карточку с текстом
        String s = Selenide.$(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)" +
                                ".instance(0)).scrollIntoView(new UiSelector().textContains(\"Apple Iphone 15\").instance(0))")).getText();
        SelenideAppium.$(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)" +
                        ".instance(0)).scrollIntoView(new UiSelector().textContains(\"Apple Iphone 15\").instance(0))"))
                .scroll(AppiumScrollOptions.with(ScrollDirection.DOWN,1))
                .click(tap());

        if(Selenide.$(AppiumBy.id("ru.ozon.app.android:id/onboardingV")).isDisplayed()) SelenideAppium.back();

        //Тапнуть на кнопку "Добавить в корзину"
        SelenideAppium.$(AppiumBy.id("ru.ozon.app.android:id/mainBtn"))
                .shouldBe(Condition.visible)
                .click(tap());

        Selenide.$(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Корзина\"]"))
                .click(tap());

        //да я ни ебу почему ancestor не работает
        Selenide.$(AppiumBy.xpath("//android.widget.TextView[@text='"+s+"']/../../../.."))
                .find(AppiumBy.id("ru.ozon.app.android:id/removeButton"))
                .click(tap());

        SelenideAppium.$(AppiumBy.xpath("//android.widget.Button[@text='УДАЛИТЬ ТОВАР']"))
                .shouldBe(Condition.visible)
                .click(tap());

        //TODO поменять ассерт
        Assert.assertTrue(
                Selenide.$(AppiumBy.xpath("//android.widget.TextView[@text='"+s+"']"))
                .isDisplayed(), "Товар не был удален из корзины"
        );
    }
}
