package elements.base;

import elements.base.BaseElement;
import elements.base.Button;
import io.appium.java_client.AppiumBy;

public class ModalWindow extends BaseElement {
    public Button confirm;
    public ModalWindow(String name) {
        super(AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Вы уверены')]/.."),
                "Модальное окно подтверждения действия: " + name);
        confirm = new Button(AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Вы уверены')]/..//android.view.ViewGroup[@resource-id=\"RNE_BUTTON_WRAPPER\"]//android.widget.Button"),
                "Подверждение");
    }


}
