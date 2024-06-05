package service;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Driver implements WebDriverProvider {
    protected static final TestConfig CONFIG = ConfigFactory.create(TestConfig.class);
    protected static AndroidDriver driver;

    public static void closeApp() {
        driver.quit();
    }

    public static void scroll(Integer startY, Integer endY) {
        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var start = new Point(550, startY);
        var end = new Point(550, endY);
        var swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(swipe));

    }

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options()
                .setAppPackage(CONFIG.getPackage())
                .setAppActivity(CONFIG.getActivity())
                .setPlatformName(CONFIG.getPlatformName())
                .setDeviceName(CONFIG.getDeviceName())
                .setAutomationName(CONFIG.getAutomationName());
        try {
            driver = new AndroidDriver(new URL(CONFIG.getUrl()), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            return driver;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
