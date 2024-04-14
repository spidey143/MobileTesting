package screens.base;

import com.codeborne.selenide.SelenideElement;
import elements.menu.Menu;
import io.qameta.allure.Step;
import screens.AuthScreen;
import screens.MainScreen;
import screens.PersonalCabinetScreen;
import screens.baggageDelivery.BaggageDeliveryScreen;
import screens.baggageDelivery.CreateOrderBaggageDeliveryScreen;
import screens.requests.CreateRequestScreen;
import screens.requests.CreatedRequestScreen;
import screens.requests.RequestsScreen;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public interface BaseScreen {
    AuthScreen authScreen = new AuthScreen();
    MainScreen mainScreen = new MainScreen();
    RequestsScreen requestsScreen= new RequestsScreen();
    CreateRequestScreen createRequestScreen = new CreateRequestScreen();
    PersonalCabinetScreen personalCabinetScreen = new PersonalCabinetScreen();
    CreatedRequestScreen createdRequestScreen = new CreatedRequestScreen();
    BaggageDeliveryScreen baggageDeliveryScreen = new BaggageDeliveryScreen();
    CreateOrderBaggageDeliveryScreen createOrderBaggageDeliveryScreen = new CreateOrderBaggageDeliveryScreen();
    Menu menu = new Menu();
}
