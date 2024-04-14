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

        baggageDeliveryScreen.addBaggageDeliveryOrderButton.buttonTap();
        createOrderBaggageDeliveryScreen.airline.openForm().selectItem(airline);
        createOrderBaggageDeliveryScreen.passengerFullName.setValue(fio);
        createOrderBaggageDeliveryScreen.phoneNumber.setValue(phoneNumber);
        createOrderBaggageDeliveryScreen.additionalPhoneNumber.setValue(additionalPhone);
        createOrderBaggageDeliveryScreen.flightNumber.setValue(flightNumber);
        createOrderBaggageDeliveryScreen.numberOfSeats.setValue(String.valueOf(numberOfSeats));
        createOrderBaggageDeliveryScreen.baggageTagNumber.setValue(baggageTagNumber);

        createOrderBaggageDeliveryScreen.deliveryDate.open().setDate(date);

        createOrderBaggageDeliveryScreen.baggageClaimAirport.openForm().selectItem(baggageClaimAirport);
        createOrderBaggageDeliveryScreen.deliveryAddress.openForm().selectItem(deliveryAddress);
        createOrderBaggageDeliveryScreen.deliveryTime.setTime(time);
        createOrderBaggageDeliveryScreen.comment.setValue(comment);

    }



    @Step("Отменить заказ на доставку багажа")
    public void cancelOrder(){

    }

    @Step("Редактировать заказ на доставку багажа")
    public void editOrder(){

    }

    @Step("фотофиксация заказа")
    public void photographicRecordingOrder(){

    }

    @Step("Подписать заказ")
    public void subscribeOrder(){

    }
}
