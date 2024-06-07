import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import service.BaseTest;
import service.RetryAnalyzer;

@Epic("Основной функционал")
@Feature("Функционал связанный с авторизацией пользователя")
public class AuthTests extends BaseTest {
    @Test(testName = "Корректная авторизация в системе", description = "Корректная авторизация в системе", retryAnalyzer = RetryAnalyzer.class)
    @Description("Проверка возможности авторизации в системе с валидным логином и паролем")
    @Owner("Daniil Bekenev")
    public void correctAuthTest(){
        AUTH_STEPS.login(CONFIG.getUsername(), CONFIG.getPassword());
        AUTH_STEPS.logout();
    }

    @Test(testName = "Некорректная авторизация в системе", description = "Некорректная авторизация в системе",
            retryAnalyzer = RetryAnalyzer.class, expectedExceptions = AssertionError.class)
    @Description("Проверка наличия уведомления о неправильном логине / пароле")
    @Owner("Daniil Bekenev")
    public void incorrectAuthTest(){
        AUTH_STEPS.login(null, null);
    }
}
