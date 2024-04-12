package steps;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import screens.base.BaseScreen;

public class RequestsSteps implements BaseScreen {

    @Step("Создать заявку")
    public void createRequest(
            String service, String customer, String office, String numberVs,
            String flightNumber, String startDate,
            String startTime, String endDate, String endTime,
            String platform, String parkingPlace, String jobView,
            Integer count, String comment, String additionalInfo
    ) {
        requestsScreen.createRequestButton.buttonTap();

        createRequestScreen.service.openForm().selectItem(service);
        createRequestScreen.customer.openForm().selectItem(customer);
        createRequestScreen.office.openForm().selectItem(office);
        createRequestScreen.numberVs.openForm().selectItem(numberVs);
        createRequestScreen.flightNumber.setValue(flightNumber);

        createRequestScreen.startPlanDp.open().setDate(startDate);
        createRequestScreen.starPlanTp.setTime(startTime);

        createRequestScreen.endPlanDp.open().setDate(endDate);
        createRequestScreen.endPlanTp.setTime(endTime);

        createRequestScreen.addDocumentButton.scrollTo();

        createRequestScreen.platform.openForm().selectItem(platform);
        createRequestScreen.parkingPlace.openForm().selectItem(parkingPlace);
        createRequestScreen.jobView.openForm().selectItem(jobView);
        createRequestScreen.count.setValue(String.valueOf(count));
        createRequestScreen.comment.setValue(comment);
        createRequestScreen.additionalInfo.setValue(additionalInfo);

        createRequestScreen.createRequestButton.buttonTap();
        createdRequestScreen.backButton.buttonTap();
    }

    @Step("Прикрепить документы к заявке")
    public void addDocumentsToRequest() {
        createRequestScreen.addDocumentButton.buttonTap();
        //
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
