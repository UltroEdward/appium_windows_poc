package org.msword.test.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Optional;

public class DocumentScreen extends BaseScreen {

    private String name;

    public DocumentScreen(WebDriver driver, String name) {
        super(driver);
        this.name = Optional.ofNullable(name).orElse("Document1");
    }

    public void enterText(String text) {
        WebElement paneElement = driver.findElement(By.xpath("//Pane[@Name=\"" + name + "\"]"));
        paneElement.sendKeys(text);
    }

    public String getText() {
        return driver.findElement(By.xpath("//Pane[@Name=\"" + name + "\"]//Edit")).getText();
    }
}
