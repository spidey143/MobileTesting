package screens;

import elements.Button;
import elements.TextField;
import io.appium.java_client.AppiumBy;

public class CommentsScreen {
    public Button backButton = new Button(AppiumBy.xpath(""), "");//TODO locator
    public Button subscribeNotificationsButton = new Button(AppiumBy.xpath(""), ""); //TODO locator
    public Button sendCommentButton = new Button(AppiumBy.xpath(""), ""); //TODO locator
    public Button addDocumentButton = new Button(AppiumBy.xpath(""), "");//TODO locator
    public TextField comment = new TextField("");//TODO locator
}
