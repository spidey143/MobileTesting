package screens.base;

import elements.menu.Menu;
import screens.AuthScreen;
import screens.CommentsScreen;
import screens.PersonalCabinetScreen;
import screens.CreateRequestScreen;
import screens.CreatedRequestScreen;
import screens.EditRequestScreen;
import screens.RequestsScreen;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public interface BaseScreen {
    AuthScreen AUTH_SCREEN = new AuthScreen();
    MainScreen MAIN_SCREEN = new MainScreen();
    RequestsScreen REQUESTS_SCREEN = new RequestsScreen();
    CreateRequestScreen CREATE_REQUEST_SCREEN = new CreateRequestScreen();
    PersonalCabinetScreen PERSONAL_CABINET_SCREEN = new PersonalCabinetScreen();
    CreatedRequestScreen CREATED_REQUEST_SCREEN = new CreatedRequestScreen();
    EditRequestScreen EDIT_REQUEST_SCREEN = new EditRequestScreen();
    CommentsScreen COMMENTS_SCREEN = new CommentsScreen();
    Menu MENU = new Menu();
}
