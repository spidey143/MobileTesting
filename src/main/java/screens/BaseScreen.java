package screens;

import elements.menu.Menu;
import screens.requests.CreateRequestScreen;
import screens.requests.RequestsScreen;

public interface BaseScreen {
    AuthScreen authScreen = new AuthScreen();
    MainScreen mainScreen = new MainScreen();
    RequestsScreen requestsScreen= new RequestsScreen();
    CreateRequestScreen createRequestScreen = new CreateRequestScreen();
    PersonalCabinetScreen personalCabinetScreen = new PersonalCabinetScreen();
    Menu menu = new Menu();
}
