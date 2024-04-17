import org.testng.annotations.Test;
import service.BaseTest;
import steps.Steps;

public class BaggageDeliveryTest extends BaseTest implements Steps {

    @Test(description= "Добавление заказа на доставку багажа")
    public void addOrderBaggageDeliveryTests() {
        BAGGAGE_DELIVERY_STEPS.createOrderOnBaggageDelivery(
                "",
                "",
                "",
                "",
                "",
                10,
                "",
                "",
                "",
                "",
                "",
                ""
        );
    }

    @Test(description= "Отменить заказ на доставку багажа")
    public void cancelOrderBaggageDeliveryTests() {
        BAGGAGE_DELIVERY_STEPS.createOrderOnBaggageDelivery(
                "",
                "",
                "",
                "",
                "",
                10,
                "",
                "",
                "",
                "",
                "",
                ""
        );
    }
}
