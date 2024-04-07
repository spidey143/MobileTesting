package service;

import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.appium.SelenideAppium;
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
    private static final TestConfig CONFIG = ConfigFactory.create(TestConfig.class);

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
            AndroidDriver driver = new AndroidDriver(new URL(CONFIG.getUrl()), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            return driver;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeApp() {
        SelenideAppium.terminateApp(CONFIG.getPackage());
    }
}
