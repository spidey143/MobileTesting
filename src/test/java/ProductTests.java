import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;
import service.BaseTest;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class ProductTests extends BaseTest {

    @Test(description = "Добавление товара в корзину")
    public void addProductToCart() {
        //Тапнуть на поле с поиском
        $(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"ru.ozon.app.android:id/searchTv\"]"))
                .hideKeyboard()
                .shouldBe(Condition.visible)
                .click(tap());

        //Ввести значение "iphone 15" в поле поиска
        $(AppiumBy.id("//android.widget.EditText[@resource-id=\"ru.ozon.app.android:id/etSearch\"]"))
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
        $$(AppiumBy.id("ru.ozon.app.android:id/tileGridItemCl"))
                .first()
                .scrollTo()
                .click(tap());

        //Тапнуть на кнопку "В корзину"
        $(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"ru.ozon.app.android:id/mainBtn\"]"))
                .shouldBe(Condition.visible).click(tap());
    }

    @Test(description = "Удаление товара из корзины")
    public void deleteProductOfCart() {
        //Тапнуть на поле с поиском
        Selenide.$(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"ru.ozon.app.android:id/searchTv\"]"))
                .shouldBe(Condition.visible)
                .click(tap());
        //Ввести значение "iphone 15" в поле поиска
        Selenide.$(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"ru.ozon.app.android:id/etSearch\"]"))
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
        Selenide.$(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)" +
                        ".instance(0)).scrollIntoView(new UiSelector().textContains(\"Apple Iphone 15\").instance(0))"))
                .click(tap());

        if(Selenide.$(AppiumBy.id("ru.ozon.app.android:id/onboardingV")).exists()) SelenideAppium.back();

        //Тапнуть на кнопку "Добавить в корзину"
        Selenide.$(AppiumBy.id("ru.ozon.app.android:id/mainBtn"))
                .shouldBe(Condition.visible)
                .click();

        Selenide.$(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Корзина\"]"))
                .click(tap());

        System.out.println(
        $$(AppiumBy.xpath("//android.widget.TextView"))
                .find(Condition.text(s)).getText());
        //да я ни ебу почему ancestor не работает
        Selenide.$(AppiumBy.xpath("//android.widget.TextView[@text='"+s+"']/../../../.."))
                .find(AppiumBy.id("ru.ozon.app.android:id/removeButton"))
                .click(tap());
        /*
        //Удалить товар из корзины
        $$(AppiumBy.xpath("//android.widget.TextView"))
                .findBy(Condition.text("Apple Смартфон Смартфон Apple Iphone 15 128 ГБ китайской версии с дисплеем Super Retina XDR диагональю 6,1 дюйма и бионическим чипом 16 iOS 16 CN 6/128 ГБ, черный"))
                .ancestor("[resource-id=ru.ozon.app.android:id/splitV2ItemRootCl]")
                .find(AppiumBy.id("ru.ozon.app.android:id/removeButton"))
                .click(tap());*/
    }
}
