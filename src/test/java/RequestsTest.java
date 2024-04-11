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
                "ЮТ, ПАО \"ЮТэйр\" (UT, UTA)",
                "UTG",
                "Офис UTG",
                "RA-73047",
                "testreys",
                "A109",
                "10.04.2024", "10:00",
                "11.04.2024", "20:00",
                "ВНК - Перрон1",
                "01 (T)",
                "Предоставление багажной тележки",
                10,
                "Тестовый комент(-_-)",
                "Тестовая доп.инфа"
        );
        logout();
    }

}
