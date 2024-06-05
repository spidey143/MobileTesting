import elements.menu.MenuSections;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import jdk.jfr.Description;
import models.RequestModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import service.BaseTest;
import service.RetryAnalyzer;
import utils.DataGenerator;

@Epic("Основной функционал")
@Feature("Функционал связанный с заявками")
public class RequestTests extends BaseTest {

    private RequestModel request;
    private String comment;
    private static final String USERNAME = CONFIG.getUsername();
    private static final String PASSWORD= CONFIG.getPassword();

    @BeforeMethod
    public void generateData() {
        request = DataGenerator.generateRequest();
        comment = DataGenerator.generateRandomString(20);
    }

    @Test(testName = "Добавление заявки", description = "Добавление заявки", retryAnalyzer = RetryAnalyzer.class)
    @Description("Тестирование возможности добавления заявки для оказания услуги")
    @Owner("Daniil Bekenev")
    public void addRequestWithRequiredFieldsTest() {
        AUTH_STEPS.login(USERNAME, PASSWORD);
        MENU.openMenuSection(MenuSections.REQUESTS);
        REQUESTS_STEPS.tapOnAddRequestButton();
        REQUESTS_STEPS.fillingRequiredFieldsRequestForm(request);
        REQUESTS_STEPS.tapOnCreateRequestButton();
        CREATED_REQUEST_SCREEN.checkRequestIsCreated();
        AUTH_STEPS.logout();
    }

    @Test(testName = "Отмена заявки", description = "Отмена заявки", retryAnalyzer = RetryAnalyzer.class)
    @Description("Тестирование возможности отмены созданой заявки")
    @Owner("Daniil Bekenev")
    public void cancelRequestTest() {
        AUTH_STEPS.login(USERNAME, PASSWORD);
        MENU.openMenuSection(MenuSections.REQUESTS);
        REQUESTS_STEPS.tapOnAddRequestButton();
        REQUESTS_STEPS.fillingRequiredFieldsRequestForm(request);
        REQUESTS_STEPS.tapOnCreateRequestButton();
        CREATED_REQUEST_SCREEN.checkRequestIsCreated();
        REQUESTS_STEPS.cancelRequest();
        CREATED_REQUEST_SCREEN.checkRequestIsCancelled();
        AUTH_STEPS.logout();
    }

    @Test(testName = "Отказ от заявки", description = "Отказ от заявки", retryAnalyzer = RetryAnalyzer.class)
    @Description("Тестирование возможности отказа от заявки")
    @Owner("Daniil Bekenev")
    public void refusalRequestTest() {
        AUTH_STEPS.login(USERNAME, PASSWORD);
        MENU.openMenuSection(MenuSections.REQUESTS);
        REQUESTS_STEPS.tapOnAddRequestButton();
        REQUESTS_STEPS.fillingRequiredFieldsRequestForm(request);
        REQUESTS_STEPS.tapOnCreateRequestButton();
        CREATED_REQUEST_SCREEN.checkRequestIsCreated();
        REQUESTS_STEPS.refusalRequest();
        CREATED_REQUEST_SCREEN.checkRequestIsRefused();
        AUTH_STEPS.logout();
    }

    @Test(testName = "Редактировать заявку", description = "Редактировать заявку", retryAnalyzer = RetryAnalyzer.class)
    @Description("Тестирование возможности редактирования созданой заявки")
    @Owner("Daniil Bekenev")
    public void editRequestTest() {
        AUTH_STEPS.login(USERNAME, PASSWORD);
        MENU.openMenuSection(MenuSections.REQUESTS);
        REQUESTS_STEPS.tapOnAddRequestButton();
        REQUESTS_STEPS.fillingRequiredFieldsRequestForm(request);
        REQUESTS_STEPS.tapOnCreateRequestButton();
        CREATED_REQUEST_SCREEN.checkRequestIsCreated();
        int requestSizeBeforeEdit = CREATED_REQUEST_SCREEN.getFieldsSize();
        REQUESTS_STEPS.tapOnEditRequestButton();
        REQUESTS_STEPS.fillingFormNotRequiredFieldsRequest(request);
        REQUESTS_STEPS.confirmEditRequest();
        CREATED_REQUEST_SCREEN.checkRequestIsEdited(requestSizeBeforeEdit);
        AUTH_STEPS.logout();
    }

    @Test(testName = "Добавить комментарий к заявке", description = "Добавить комментарий к заявке", retryAnalyzer = RetryAnalyzer.class)
    @Description("Тестирование возможности добавления комментария к заявке")
    @Owner("Daniil Bekenev")
    public void addCommentToRequestTest() {
        AUTH_STEPS.login(USERNAME, PASSWORD);
        MENU.openMenuSection(MenuSections.REQUESTS);
        REQUESTS_STEPS.tapOnAddRequestButton();
        REQUESTS_STEPS.fillingRequiredFieldsRequestForm(request);
        REQUESTS_STEPS.tapOnCreateRequestButton();
        CREATED_REQUEST_SCREEN.checkRequestIsCreated();
        REQUESTS_STEPS.addCommentToRequest(comment);
        COMMENTS_SCREEN.checkCommentIsSent(comment);
        AUTH_STEPS.logout();
    }

}
