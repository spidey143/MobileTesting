import com.beust.ah.A;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileCommand;
import org.testng.annotations.Test;
import service.BaseTest;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class ExampleTestOzon extends BaseTest {

    @Test(description = "Добавление товара в корзину")
    public void addProductToCart() {
        //Тапнуть на поле с поиском
        $(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"ru.ozon.app.android:id/searchTv\"]"))
                .hideKeyboard()
                .shouldBe(Condition.visible)
                .click(tap());

        //Ввести значение "iphone 15" в поле поиска
        $(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"ru.ozon.app.android:id/etSearch\"]"))
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
        $$(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"tile-name\"]"))
                .find(Condition.text("Apple Iphone 15"))
                .scrollTo()
                .click(tap());

        //Тапнуть на кнопку "В корзину"
        $(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"ru.ozon.app.android:id/mainBtn\"]"))
                .shouldBe(Condition.visible).click(tap());
    }

    @Test(description = "Удаление товара из корзины")
    public void deleteProductOfCart() {
        //Тапнуть на поле с поиском
        $(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"ru.ozon.app.android:id/searchTv\"]"))
                .hideKeyboard()
                .shouldBe(Condition.visible)
                .click(tap());

        //Ввести значение "iphone 15" в поле поиска
        $(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"ru.ozon.app.android:id/etSearch\"]"))
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
        $$(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"tile-name\"]"))
                .find(Condition.matchText(
                        "Apple Iphone 15")
                )
                .scrollTo()
                .click(tap());
        //Тапнуть на кнопку "В корзину"
        $(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"ru.ozon.app.android:id/mainBtn\"]"))
                .shouldBe(Condition.visible).click(tap());
        //тапнуть на иконку корзины
        $(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Корзина\"]"))
                .click(tap());

        //Удалить товар из корзины
        for (SelenideElement element: $$(AppiumBy.xpath("//android.widget.TextView"))) {
            System.out.println(element.parent().parent());
        }
        /*$$(AppiumBy.xpath("//android.widget.TextView"))
                .find(Condition.matchText("Apple Iphone 15")).ancestor("[resource-id=ru.ozon.app.android:id/splitV2ItemRootCl]")
                .findElement("/android.widget.ImageView[@resource-id=\"ru.ozon.app.android:id/removeButton\"]")
                .click(tap());*/
    }

    /*@Test(description = "Оставить отзыв на товар")
    public void sendFeedbackProduct() {
        driver.findElement(AppiumBy.id("searchTv")).click();
        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Корзина\"]")).click();
        driver.findElement(AppiumBy.id("etSearch")).sendKeys("iphone 15");
    }*/
}
