import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import service.BaseTest;

public class ExampleTestOzon extends BaseTest {

    @Test(description = "Добавление товара в корзину")
    public void addProductToCart() {
        driver.findElement(AppiumBy.id("searchTv")).click();
        driver.findElement(AppiumBy.id("etSearch")).sendKeys("iphone 15");
        driver.findElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"ru.ozon.app.android:id/listRv\"]/android.view.ViewGroup[1]"))
                        .click();
        driver.findElement(AppiumBy.xpath("(//android.widget.FrameLayout[@content-desc=\"grid\"])[1]"));
        driver.findElement(By.xpath("//android.view.View[@resource-id=\"ru.ozon.app.android:id/addToCartButton\"][1]")).click();
        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Корзина\"]")).click();

    }

    @Test(description = "Удаление товара из корзины в корзину")
    public void deleteProductOfCart() {
        driver.findElement(AppiumBy.id("searchTv")).click();
        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Корзина\"]")).click();
        driver.findElement(AppiumBy.id("etSearch")).sendKeys("iphone 14");
    }

    @Test(description = "Оставить отзыв на товар")
    public void sendFeedbackProduct() {
        driver.findElement(AppiumBy.id("searchTv")).click();
        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Корзина\"]")).click();
        driver.findElement(AppiumBy.id("etSearch")).sendKeys("iphone 15");
    }
}
