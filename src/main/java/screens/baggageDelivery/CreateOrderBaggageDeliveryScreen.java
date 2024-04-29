package screens.baggageDelivery;

import elements.base.Button;
import elements.base.SelectForm;
import elements.base.TextField;
import elements.pickers.DatePicker;
import elements.pickers.TimePicker;

public class CreateOrderBaggageDeliveryScreen {
    public SelectForm airline = new SelectForm("Авиакомпания*");
    public TextField passengerFullName = new TextField("ФИО пассажира*");
    public TextField phoneNumber = new TextField("ФИО пассажира*");;
    public TextField additionalPhoneNumber = new TextField("ФИО пассажира*");;
    public TextField flightNumber = new TextField("ФИО пассажира*");;
    public TextField numberOfSeats = new TextField("ФИО пассажира*");;
    public TextField baggageTagNumber = new TextField("ФИО пассажира*");;
    public SelectForm baggageClaimAirport = new SelectForm("Аэропорт выдачи багажа*");
    public SelectForm deliveryAddress = new SelectForm("Адрес доставки*");
    public DatePicker deliveryDate = new DatePicker("Дата доставки*");
    public TimePicker deliveryTime = new TimePicker("Время доставки*");
    public TextField comment = new TextField("Комментарий");
    public Button cancelButton;
    public Button createButton;
}
