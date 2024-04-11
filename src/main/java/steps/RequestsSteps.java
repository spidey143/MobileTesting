package steps;

import io.qameta.allure.Step;
import screens.BaseScreen;

public class RequestsSteps implements BaseScreen {

    @Step("Создать заявку")
    public void createRequest(
            String service, String customer, String office, String numberVs,
            String flightNumber, String typeVs, String startDate,
            String startTime, String endDate, String endTime,
            String platform, String parkingPlace, String jobView,
            Integer count, String comment, String additionalInfo
    ) {
        requestsScreen.createRequestButton.buttonTap();
        createRequestScreen.service.open().selectItem(service);
        createRequestScreen.customer.open().selectItem(customer);
        /*createRequestScreen.airline.open().selectItem(airline);
        createRequestScreen.operator.open().selectItem(operator);*/

        createRequestScreen.office.open().selectItem(office);
        createRequestScreen.numberVs.open().selectItem(numberVs);


        createRequestScreen.flightNumber.setValue(flightNumber);


        createRequestScreen.typeVs.open().selectItem(typeVs);


        createRequestScreen.startPlanDp.open().setDate(startDate);
        createRequestScreen.starPlanTp.setTime(startTime);

        createRequestScreen.endPlanDp.open().setDate(endDate);
        createRequestScreen.endPlanTp.setTime(endTime);
        createRequestScreen.platform.open().selectItem(platform);
        createRequestScreen.parkingPlace.open().selectItem(parkingPlace);
        createRequestScreen.jobView.open().selectItem(jobView);

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
