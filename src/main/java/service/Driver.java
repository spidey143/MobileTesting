package service;

import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.appium.*;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

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
                .setNoReset(CONFIG.getNoReset());
        try {
            driver = new AndroidDriver(new URL(CONFIG.getUrl()), options);
            return driver;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeApp() {
        driver.quit();
    }
}
