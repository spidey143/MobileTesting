import org.testng.annotations.Test;
import service.BaseTest;
import steps.Steps;

public class TestBugs extends BaseTest implements Steps {
    @Test
    public void test() {
        login();
        logout();
    }
}
