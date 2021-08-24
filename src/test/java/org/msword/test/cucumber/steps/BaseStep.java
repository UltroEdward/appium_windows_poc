package org.msword.test.cucumber.steps;

import io.appium.java_client.windows.WindowsDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BaseStep {

    protected WindowsDriver appDriver;
    @Value("${appium.server}")
    private String appiumServer;
    @Value("${appium.wait}")
    private Long appiumWait;
    @Value("${application.ms-word.executable}")
    private String appExecutable;
    private DesiredCapabilities capabilities;

    @PostConstruct
    public void init() {
        capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setCapability("automationName", "Windows");
        capabilities.setCapability("deviceName", "WindowsPC");
        capabilities.setCapability("app", appExecutable);
        capabilities.setCapability("appArguments", "/q");
    }

    public void newSession() {
        log.info("Start new driver session");
        try {
            appDriver = new WindowsDriver(new URL(appiumServer), capabilities);
            appDriver.manage().timeouts().implicitlyWait(appiumWait, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeSession() {
        if (appDriver != null) {
            log.info("Shutdown current driver session");
            appDriver.quit();
        }
    }

}
