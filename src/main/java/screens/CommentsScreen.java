package screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import elements.base.Button;
import elements.base.TextField;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$$;

public class CommentsScreen {
    public TextField commentField = new TextField(AppiumBy.xpath("//android.widget.EditText[@text=\"Комментарий\"]"),
            "Оставить комментарий");
    public Button sendCommentButton = new Button(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"RNE__ICON__Component\" and @text=\"\uE163\"]"),
            "Отправить комментарий");

    private ElementsCollection comments = $$(AppiumBy.xpath("//android.widget.ScrollView//android.widget.TextView"));
    @Step("Проверить что комментарий: {comment} успешно добавлен")
    public void checkCommentIsSent(String comment){
        Assert.assertTrue(
                comments.find(Condition.text(comment)).shouldBe(Condition.visible).isDisplayed(),
                "Комментарий не добавлен"
        );
    }
}
