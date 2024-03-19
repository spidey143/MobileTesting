package service;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    private static final TestConfig CONFIG = ConfigFactory.create(TestConfig.class);

    public AndroidDriver createDriver() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setAppPackage(CONFIG.getPackage())
                .setAppActivity(CONFIG.getActivity())
                .setPlatformName(CONFIG.getPlatformName())
                .setDeviceName(CONFIG.getDeviceName())
                .setAutomationName(CONFIG.getAutomationName())
                .setNoReset(CONFIG.getNoReset());
        try {
            return new AndroidDriver(new URL(CONFIG.getUrl()), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
