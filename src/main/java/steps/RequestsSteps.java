package steps;

import io.qameta.allure.Step;
import screens.BaseScreen;

public class RequestsSteps implements BaseScreen {

    @Step("Создать заявку")
    public void createRequest(
            String service, String customer, String airline,
            String operator, String office, String numberVs,
            String flightNumber, String typeVs, String startDate,
            String startTime, String endDate, String endTime,
            String platform, String parkingPlace, String jobView,
            Integer count, String comment, String additionalInfo
    ) {
        requestsScreen.createRequestButton.buttonTap();
        createRequestScreen.service.selectItem(service);
        createRequestScreen.customer.selectItem(customer);
        createRequestScreen.airline.selectItem(airline);
        createRequestScreen.operator.selectItem(operator);
        createRequestScreen.office.selectItem(office);
        createRequestScreen.numberVs.selectItem(numberVs);
        createRequestScreen.flightNumber.setValue(flightNumber);
        createRequestScreen.typeVs.selectItem(typeVs);
        createRequestScreen.startPlanDp.setDate(startDate);
        createRequestScreen.starPlanTp.setTime(startTime);
        createRequestScreen.endPlanDp.setDate(endDate);
        createRequestScreen.endPlanTp.setTime(endTime);
        createRequestScreen.platform.selectItem(platform);
        createRequestScreen.parkingPlace.selectItem(parkingPlace);
        createRequestScreen.jobView.selectItem(jobView);
        createRequestScreen.count.setValue(String.valueOf(count));
        createRequestScreen.comment.setValue(comment);
        createRequestScreen.additionalInfo.setValue(additionalInfo);
        createRequestScreen.createRequestButton.buttonTap();
    }

    @Step("Прикрепить документы к заявке")
    public void addDocumentsToRequest() {

    }

    @Step("Отменить заявку")
    public void deleteRequest() {

    }

    @Step("Добавить комментарий к заявке")
    public void addCommentToRequest() {

    }

    @Step("Редактировать заказ на доставку багажа")
    public void editRequest() {

    }

    @Step("Скопировать заявку")
    public void copyRequest() {

    }
}
