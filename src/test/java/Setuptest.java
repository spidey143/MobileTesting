import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import service.BaseTest;

public class Setuptest extends BaseTest {

    @Test
    public void test1() {
        login();
        Selenide.sleep(5000);
    }
}
