package org.msword.test.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.msword.test.SpringBootMSWordTestApplication;
import org.msword.test.SpringTestConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = SpringBootMSWordTestApplication.class, webEnvironment = WebEnvironment.NONE)
@ContextConfiguration(classes = SpringTestConfiguration.class)
public class CucumberSpringContextConfiguration {

}