package service;

import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

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
                .setAutomationName(CONFIG.getAutomationName());
        try {
            return new AndroidDriver(new URL(CONFIG.getUrl()), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeDriver(){
        SelenideAppium.terminateApp(CONFIG.getPackage());
    }
}
