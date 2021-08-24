package org.msword.test.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;

@Slf4j
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "org.msword.test",
        plugin = {
                "pretty",
                "json:target/cucumber-report.json",
                "html:target/cucumber-report.html",
                "junit:target/junit-results.xml"
        },
        tags = "not @wip")
public class CucumberTest {

}
