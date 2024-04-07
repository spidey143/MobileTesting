package service;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:resources.properties")
public interface TestConfig extends Config {

    @Config.Key("deviceName")
    String getDeviceName();

    @Config.Key("platformName")
    String getPlatformName();

    @Config.Key("url")
    String getUrl();

    @Config.Key("app")
    String getApp();

    @Config.Key("package")
    String getPackage();

    @Config.Key("activity")
    String getActivity();

    @Config.Key("automationName")
    String getAutomationName();

    @Config.Key("noReset")
    Boolean getNoReset();
}
