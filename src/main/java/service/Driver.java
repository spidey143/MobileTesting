package service;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.appium.*;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v120.input.Input;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Driver implements WebDriverProvider {
    protected static final TestConfig CONFIG = ConfigFactory.create(TestConfig.class);
    protected static AndroidDriver driver;

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options()
                .setAppPackage(CONFIG.getPackage())
                .setAppActivity(CONFIG.getActivity())
                .setPlatformName(CONFIG.getPlatformName())
                .setDeviceName(CONFIG.getDeviceName())
                .setAutomationName(CONFIG.getAutomationName())
                .setNewCommandTimeout(Duration.ofSeconds(20))
                .setAppWaitDuration(Duration.ofSeconds(10))
                .setAdbExecTimeout(Duration.ofSeconds(20))
                .setNoReset(true);
        try {
            driver = new AndroidDriver(new URL(CONFIG.getUrl()), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            return driver;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeApp() {
        driver.quit();
    }

    public static void scroll(Integer x) {
        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var start = new Point(483, 1812);
        var end = new Point (497, 966 - x);
        var swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(swipe));

    }
}
