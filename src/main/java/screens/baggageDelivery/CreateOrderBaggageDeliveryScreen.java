package screens.baggageDelivery;

import com.codeborne.selenide.SelenideElement;
import elements.Button;

public class CreateOrderBaggageDeliveryScreen {
    private SelenideElement airline;
    private SelenideElement passengerFullName;
    private SelenideElement phoneNumber;
    private SelenideElement additionalPhoneNumber;
    private SelenideElement flightNumber;
    private SelenideElement numberOfSeats;
    private SelenideElement baggageTagNumber;
    private SelenideElement baggageClaimAirport;
    private SelenideElement deliveryAddress;
    private SelenideElement deliveryDate;
    private SelenideElement deliveryTime;
    private SelenideElement comment;
    public Button cancelButton;
    public Button createButton;
}
