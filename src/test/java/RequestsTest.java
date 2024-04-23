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
        REQUESTS_STEPS.fillingFormRequest(
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
        REQUESTS_STEPS.tapOnCreateRequestButton();
        REQUESTS_STEPS.checkRequestIsCreated();
        logout();
    }

    @Test(testName = "Отмена заявки", description = "Отмена заявки")
    @Description("Тестирование возможности отмены ранее созданой заявки")
    public void cancelRequestTest(){
        login();
        REQUESTS_STEPS.fillingFormRequest(
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
        REQUESTS_STEPS.tapOnCreateRequestButton();
        REQUESTS_STEPS.checkRequestIsCreated();
        REQUESTS_STEPS.scrollToCreatedRequestActions();
        REQUESTS_STEPS.cancelRequest();
        REQUESTS_STEPS.checkRequestIsCancelled();
        logout();
    }

    @Test(testName = "Отказ от заявки", description = "Отказ от заявки")
    @Description("Тестирование возможности отказаться от заявки")
    public void refusalRequestTest(){
        login();
        REQUESTS_STEPS.fillingFormRequest(
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
        REQUESTS_STEPS.tapOnCreateRequestButton();
        REQUESTS_STEPS.checkRequestIsCreated();
        REQUESTS_STEPS.scrollToCreatedRequestActions();
        REQUESTS_STEPS.refusalRequest();
        REQUESTS_STEPS.checkRequestIsRefusal();
        logout();
    }

    /*@Test(testName = "Редактировать заявку", description =  "Редактировать заявку")
    @Description("Тестирование возможности редактирования ранее созданой заявки")
    public void editRequestTest(){
        REQUESTS_STEPS.editRequest
    }*/

}
