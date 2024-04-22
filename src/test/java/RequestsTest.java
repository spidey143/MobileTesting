import com.codeborne.selenide.Selenide;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import service.BaseTest;
import steps.RequestsSteps;
import steps.Steps;

public class RequestsTest extends BaseTest implements Steps {
    @Test(testName = "Добавление заявки", description = "Добавление заявки")
    @Description("Тестирование возмонжости добавления заявки для оказания услуги")
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
        REQUESTS_STEPS.checkActionIsSuccess("Создание заявки");
        logout();
    }

    @Test(testName = "Отмена заявки", description = "Отмена заявки")
    @Description("Тестирование возможности отмены ранее созданой заявки")
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
        REQUESTS_STEPS.checkActionIsSuccess("Создание заявки");
        REQUESTS_STEPS.cancelRequest();
        REQUESTS_STEPS.checkActionIsSuccess("Отмена заявки");
        logout();
    }

    /*@Test(testName = "Отказ от заявки", description = "Отказ от заявки")
    @Description("Тестирование возможности отказаться от заявки")
    public void refusalRequestTest(){
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
    }*/

    /*@Test(testName = "Редактировать заявку", description =  "Редактировать заявку")
    @Description("Тестирование возможности редактирования ранее созданой заявки")
    public void editRequestTest(){
        REQUESTS_STEPS.editRequest
    }*/

}
