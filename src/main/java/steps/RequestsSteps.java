package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.testng.Assert;
import screens.base.BaseScreen;
import service.Driver;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class RequestsSteps implements BaseScreen {

    @Step("Заполнить форму заявки")
    public void fillingFormRequest(
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
        Driver.scroll(1700, 50);
        createRequestScreen.platform.openForm().selectItem(platform);
        Selenide.sleep(1000);
        createRequestScreen.parkingPlace.openForm().selectItem(parkingPlace);
        createRequestScreen.jobView.openForm().selectItem(jobView);
        createRequestScreen.count.setValue(String.valueOf(count));
        createRequestScreen.comment.setValue(comment);
        createRequestScreen.additionalInfo.setValue(additionalInfo);
    }

    @Step("Нажать на кнопку \"Создать заявку\"")
    public void tapOnCreateRequestButton(){
        createRequestScreen.createRequestButton.buttonTap();
    }
    public void scrollToCreatedRequestActions() {
        createdRequestScreen.copyRequestButton.scrollTo();
    }
    @Step("Прикрепить документы к заявке")
    public void addDocumentsToRequest() {
        createRequestScreen.addDocumentButton.buttonTap();
    }

    @Step("Отменить заявку")
    public void cancelRequest() {
        createdRequestScreen.cancelRequestButton.buttonTap();
        createdRequestScreen.cancelRequestModalWindow.confirm.buttonTap();
    }

    @Step("Отказаться от заявки")
    public void refusalRequest(){
        createdRequestScreen.refusalServiceButton.buttonTap();
        createdRequestScreen.refusalRequestModalWindow.confirm.buttonTap();
    }

    @Step("Добавить комментарий к заявке")
    public void addCommentToRequest(String requestNumber) {
        createdRequestScreen.chatButton.buttonTap();
    }

    @Step("Проверить что заявка отменена")
    public void checkRequestIsCancelled(){
        scrollToCreatedRequestActions();
        Assert.assertFalse(
                createdRequestScreen.cancelRequestButton.isVisibility(),
                "Заявка не отменена!"
        );
    }

    @Step("Проверить что заявка создана")
    public void checkRequestIsCreated(){
        Assert.assertTrue(
                createdRequestScreen.chatButton.isVisibility(),
                "Заявка не создана!"
        );
    }

    @Step("Проверить что произошел отказ от заявки")
    public void checkRequestIsRefusal(){
    }
}
