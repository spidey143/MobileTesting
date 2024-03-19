package service;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected AndroidDriver driver;

    @BeforeClass(description = "Инициализация")
    public void setUp(){
        driver = new Driver().createDriver();
        driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
    };

    @AfterClass(description = "Завершение")
    public void tearDown(){
        driver.quit();
    };
}
