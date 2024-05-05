package steps;

import elements.menu.MenuSections;
import io.qameta.allure.Step;
import screens.base.BaseScreen;

public class BaggageDeliverySteps implements BaseScreen {


    @Step("Создать заказ на доставку багажа")
    public void createOrderOnBaggageDelivery(
            String airline,
            String fio,
            String phoneNumber,
            String additionalPhone,
            String flightNumber,
            Integer numberOfSeats,
            String baggageTagNumber,
            String baggageClaimAirport,
            String deliveryAddress,
            String date,
            String time,
            String comment
    ){
        menu.openMenuSection(MenuSections.BAGGAGE_DELIVERY);

    }


    @Step("Отменить заказ на доставку багажа")
    public void cancelOrder(){

    }

    @Step("Редактировать заказ на доставку багажа")
    public void editOrder(){

    }

    @Step("Фотофиксация заказа на доставку багажа")
    public void photographicRecordingOrder(){

    }

    @Step("Подписать заказ №{orderNumber} на доставку багажа")
    public void subscribeOrder(String orderNumber){

    }
}
