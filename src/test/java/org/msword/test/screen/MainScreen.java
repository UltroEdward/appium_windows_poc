package org.msword.test.screen;

import io.appium.java_client.pagefactory.WindowsFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainScreen extends BaseScreen {

    private By saveButtonLocator = By.xpath("//List[@Name=\"File\"]//ListItem[@Name=\"Save\"]");
    private By closeButtonLocator = By.xpath("//List[@Name=\"File\"]//ListItem[@Name=\"Close\"]");
    private By openButtonLocator = By.xpath("//List[@Name=\"File\"]//ListItem[@Name=\"Open\"]");
    private By saveBrowseButtonLocator = By.xpath("//Menu[@Name=\"Saving Features\"]//Button[@Name=\"Browse\"]");
    private By openBrowseButtonLocator = By.xpath("//Menu[@Name=\"Open\"]//Button[@Name=\"Browse\"]");

    @WindowsFindBy(xpath = "//Pane[@AutomationId=\"BackstageView\"]//ListItem[@Name=\"Blank document\"]")
    private WebElement blankDocument;

    @WindowsFindBy(xpath = "//Button[@AutomationId=\"FileTabButton\"]")
    private WebElement fileTabButton;

    @WindowsFindBy(xpath = "//Window[@Name=\"Word\"]//List[@AutomationId=\"NavBarMenu\"]")
    private WebElement navbarMenu;


    public MainScreen(WebDriver driver) {
        super(driver);
    }

    public boolean isNavBarMenuPresented() {
        return navbarMenu.isDisplayed();
    }


    public void newDocument() {
        blankDocument.click();
    }

    public void save() {
        fileTabButton.click();

        WebElement saveButton = driver.findElement(saveButtonLocator);
        saveButton.click();
    }

    public void saveAs(String path) {
        fileTabButton.click();

        WebElement saveButton = driver.findElement(saveButtonLocator);
        saveButton.click();

        WebElement browseButton = driver.findElement(saveBrowseButtonLocator);
        browseButton.click();

        SaveAsDialogScreen saveAsDialogScreen = new SaveAsDialogScreen(driver);
        saveAsDialogScreen.save(path);
    }

    public void closeDocument() {
        fileTabButton.click();

        WebElement closeButton = driver.findElement(closeButtonLocator);
        closeButton.click();
    }

    public void openDocument(String path) {
        fileTabButton.click();

        WebElement openButton = driver.findElement(openButtonLocator);
        openButton.click();

        WebElement browseButton = driver.findElement(openBrowseButtonLocator);
        browseButton.click();

        OpenDialogScreen openDialogScreen = new OpenDialogScreen(driver);
        openDialogScreen.open(path);
    }
}
