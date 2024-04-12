import org.testng.annotations.Test;
import service.BaseTest;
import steps.Steps;

public class TestBugs extends BaseTest implements Steps {
    @Test
    public void test() {
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
                "01 (T)",
                "Предоставление багажной тележки",
                10,
                "Тестовый комент(-_-)",
                "Тестовая доп.инфа"
        );
        logout();
        logout();
    }
}
