package org.msword.test.cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Step;
import lombok.extern.slf4j.Slf4j;
import org.msword.test.cucumber.ScenarioContext;
import org.msword.test.screen.DocumentScreen;
import org.msword.test.screen.MainScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class MSWordStep extends BaseStep {

    @Value("${application.ms-word.store-dir}")
    private String storeDir;

    @Autowired
    private ScenarioContext scenarioContext;

    @Step("I start MS Word application")
    public void startApplication() {
        //wait for app started and visible
        new MainScreen(appDriver).isNavBarMenuPresented();
    }

    @Step("I create new document")
    public void createNewDocument() {
        MainScreen mainScreen = new MainScreen(appDriver);
        mainScreen.newDocument();
    }

    @Step("I type {string}")
    public void typeText(String text) {
        DocumentScreen document = new DocumentScreen(appDriver, scenarioContext.getFileName());
        document.enterText(text);
    }

    @Step("I save document with name {string}")
    public void saveDocumentAs(String name) {
        String fullPath = Paths.get(storeDir, name).toAbsolutePath().toString();
        new MainScreen(appDriver).saveAs(fullPath);
    }

    @Step("I save document")
    public void saveDocument() {
        new MainScreen(appDriver).save();
    }

    @Step("I close current document")
    public void closeCurrent() {
        new MainScreen(appDriver).closeDocument();
    }

    @Step("I open document with name {string}")
    public void openDocument(String name) {
        scenarioContext.setFileName(name);
        String fullPath = Paths.get(storeDir, name).toAbsolutePath().toString();

        new MainScreen(appDriver).openDocument(fullPath);
    }

    @Step("document contains {string}")
    public void documentContains(String expected) {
        String documentName = scenarioContext.getFileName();
        String actual = new DocumentScreen(appDriver, documentName).getText();

        assertThat(actual).isEqualTo(expected);
    }

    @Step("I close MS Word application")
    public void closeApplication() {
        appDriver.closeApp();
    }

    @Before
    public void createSession() {
        newSession();
    }

    @After
    public void closeSession() {
        try {
            if (scenarioContext.getFileName() != null) {
                Files.delete(Paths.get(storeDir, scenarioContext.getFileName()).toAbsolutePath());
            }
        } catch (IOException e) {
            //ignore
        } finally {
            super.closeSession();
        }
    }
}
