package org.msword.test.screen;

import io.appium.java_client.pagefactory.WindowsFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SaveAsDialogScreen extends BaseScreen {

    @WindowsFindBy(xpath = "//Window[@Name=\"Save As\"]//Edit[@Name=\"File name:\"]")
    private WebElement fileNameEdit;

    @WindowsFindBy(xpath = "//Window[@Name=\"Save As\"]//Button[@Name=\"Save\"]")
    private WebElement saveButton;

    public SaveAsDialogScreen(WebDriver driver) {
        super(driver);
    }

    public void save(String path) {
        fileNameEdit.click();
        fileNameEdit.clear();
        fileNameEdit.sendKeys(path);

        saveButton.click();
    }
}
