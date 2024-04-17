package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import screens.base.BaseScreen;
import service.Driver;

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

        Driver.scroll(0);
        Selenide.sleep(1000);
        createRequestScreen.platform.openForm().selectItem(platform);
        Driver.scroll(50);
        Selenide.sleep(1000);
        createRequestScreen.parkingPlace.openForm().selectItem(parkingPlace);
        Driver.scroll(100);
        Selenide.sleep(1000);
        createRequestScreen.jobView.openForm().selectItem(jobView);
        createRequestScreen.count.setValue(String.valueOf(count));

        createRequestScreen.comment.scrollTo();
        createRequestScreen.comment.setValue(comment);

        createRequestScreen.additionalInfo.scrollTo();
        createRequestScreen.additionalInfo.setValue(additionalInfo);

        createRequestScreen.createRequestButton.buttonTap();
        Selenide.sleep(5000);
    }

    @Step("Прикрепить документы к заявке")
    public void addDocumentsToRequest() {
        createRequestScreen.addDocumentButton.buttonTap();
    }

    @Step("Отменить заявку")
    public void cancelRequest() {
        createdRequestScreen.cancelRequestButton.scrollTo();
        createdRequestScreen.cancelRequestButton.buttonTap();
    }

    @Step("Добавить комментарий к заявке")
    public void addCommentToRequest(String requestNumber) {
        createdRequestScreen.chatButton.buttonTap();
    }

    @Step("Скопировать заявку")
    public void copyRequest() {

    }
}
