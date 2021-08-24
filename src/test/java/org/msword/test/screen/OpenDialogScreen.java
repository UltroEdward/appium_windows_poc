package org.msword.test.screen;

import io.appium.java_client.pagefactory.WindowsFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenDialogScreen extends BaseScreen {

    @WindowsFindBy(xpath = "//Window[@Name=\"Open\"]//Edit[@Name=\"File name:\"]")
    private WebElement fileNameEdit;
    @WindowsFindBy(xpath = "//Window[@Name=\"Open\"]//SplitButton[@Name=\"Open\"]")
    private WebElement openButton;

    public OpenDialogScreen(WebDriver driver) {
        super(driver);
    }

    public void open(String path) {
        fileNameEdit.click();
        fileNameEdit.clear();
        fileNameEdit.sendKeys(path);

        openButton.click();
    }

}
