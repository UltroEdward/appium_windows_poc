package org.msword.test.cucumber;

import io.cucumber.spring.ScenarioScope;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ScenarioScope
@Getter
@Setter
public class ScenarioContext {

    private String fileName;

}
