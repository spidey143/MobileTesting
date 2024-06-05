package steps;

import io.qameta.allure.Step;
import models.RequestModel;
import screens.base.BaseScreen;
import service.Driver;

public class RequestsSteps implements BaseScreen {

    @Step("Заполнить обязательные поля формы заявки")
    public void fillingRequiredFieldsRequestForm(RequestModel requestModel) {
        CREATE_REQUEST_SCREEN.service.openForm().selectItem(requestModel.getService());
        CREATE_REQUEST_SCREEN.customer.openForm().selectItem(requestModel.getCustomer());
        CREATE_REQUEST_SCREEN.startPlanDp.open().setDate(requestModel.getStartDate());
        CREATE_REQUEST_SCREEN.starPlanTp.setTime(requestModel.getStartTime());
        Driver.scroll(1700, 50);
        CREATE_REQUEST_SCREEN.platform.openForm().selectItem(requestModel.getPlatform());
        CREATE_REQUEST_SCREEN.parkingPlace.openForm().selectItem(requestModel.getParkingPlace());
        CREATE_REQUEST_SCREEN.jobView.openForm().selectItem(requestModel.getJobView());
        CREATE_REQUEST_SCREEN.count.setValue(String.valueOf(requestModel.getCount()));
    }

    @Step("Заполнить необязательные поля формы заявки")
    public void fillingFormNotRequiredFieldsRequest(RequestModel requestModel) {
        CREATE_REQUEST_SCREEN.typeVs.openForm().selectItem(requestModel.getTypeVs());
        CREATE_REQUEST_SCREEN.flightNumber.setValue(requestModel.getFlightNumber());
        CREATE_REQUEST_SCREEN.endPlanDp.open().setDate(requestModel.getEndDate());
        CREATE_REQUEST_SCREEN.endPlanTp.setTime(requestModel.getEndTime());
        Driver.scroll(1700, 50);
        CREATE_REQUEST_SCREEN.comment.setValue(requestModel.getComment());
        CREATE_REQUEST_SCREEN.additionalInfo.setValue(requestModel.getAdditionalInfo());
    }

    @Step("Нажать на кнопку \"Добавить заявку\"")
    public void tapOnAddRequestButton() {
        REQUESTS_SCREEN.createRequestButton.buttonTap();
    }

    @Step("Нажать на кнопку \"Создать заявку\"")
    public void tapOnCreateRequestButton() {
        CREATE_REQUEST_SCREEN.createRequestButton.buttonTap();
    }

    @Step("Отменить заявку")
    public void cancelRequest() {
        CREATED_REQUEST_SCREEN.openRequestActionsPanel();
        CREATED_REQUEST_SCREEN.cancelRequestButton.buttonTap();
        CREATED_REQUEST_SCREEN.cancelRequestModalWindow.confirm.buttonTap();
    }

    @Step("Отказаться от заявки")
    public void refusalRequest() {
        CREATED_REQUEST_SCREEN.openRequestActionsPanel();
        CREATED_REQUEST_SCREEN.refusalServiceButton.buttonTap();
        CREATED_REQUEST_SCREEN.refusalRequestModalWindow.confirm.buttonTap();
    }

    @Step("Добавить комментарий к заявке")
    public void addCommentToRequest(String comment) {
        CREATED_REQUEST_SCREEN.chatButton.buttonTap();
        COMMENTS_SCREEN.commentField.setValue(comment);
        COMMENTS_SCREEN.sendCommentButton.buttonTap();
    }

    @Step("Нажать на кнопку \"Редактировать заявку\"")
    public void tapOnEditRequestButton() {
        CREATED_REQUEST_SCREEN.openRequestActionsPanel();
        CREATED_REQUEST_SCREEN.editRequestButton.buttonTap();
    }

    @Step("Подтвердить редактирование заявки")
    public void confirmEditRequest() {
        EDIT_REQUEST_SCREEN.confirmEditRequestButton.buttonTap();
    }
}
