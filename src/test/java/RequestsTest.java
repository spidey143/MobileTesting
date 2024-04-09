import org.testng.annotations.Test;
import service.BaseTest;
import steps.RequestsSteps;
import steps.Steps;

public class RequestsTest extends BaseTest implements Steps {
    @Test(testName = "Добавление заявки")
    public void addRequestTest(){
        login();
        REQUESTS_STEPS.createRequest();
        logout();
    }

    @Test(testName = "Редактирование заявки")
    public void editRequestTest(){
        login();
        REQUESTS_STEPS.createRequest();
        logout();
    }

}
