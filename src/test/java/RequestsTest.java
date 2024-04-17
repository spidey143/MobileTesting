import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import service.BaseTest;
import steps.RequestsSteps;
import steps.Steps;

public class RequestsTest extends BaseTest implements Steps {
    @Test(testName = "Добавление заявки")
    public void addRequestTest(){
        login();
        REQUESTS_STEPS.createRequest(
                "Предоставление спецтехники и оборудования для погрузочно-разгрузочных работ",
                "АЗУР эйр",
                "Офис UTG",
                "RA-73080",
                "testreys",
                "10.04.2024", "10:00",
                "11.04.2024", "20:00",
                "ВНК - Перрон1",
                "10 (ТЭ)",
                "Предоставление багажной тележки",
                10,
                "Тестовый комент(-_-)",
                "Тестовая доп.инфа"
        );
        Selenide.sleep(1000);
        logout();
    }

    @Test(testName = "Отменить заявку")
    public void cancelRequestTest(){
        login();
        REQUESTS_STEPS.createRequest(
                "Предоставление спецтехники и оборудования для погрузочно-разгрузочных работ",
                "АЗУР эйр",
                "Офис UTG",
                "RA-73080",
                "testreys",
                "10.04.2024", "10:00",
                "11.04.2024", "20:00",
                "ВНК - Перрон1",
                "10 (ТЭ)",
                "Предоставление багажной тележки",
                10,
                "Тестовый комент(-_-)",
                "Тестовая доп.инфа"
        );
        Selenide.sleep(1000);
        REQUESTS_STEPS.cancelRequest();
        logout();
    }

}
