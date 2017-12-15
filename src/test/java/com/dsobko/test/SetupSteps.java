package com.dsobko.test;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;


@CucumberStep
public class SetupSteps {

    private Logger log = getLogger(SetupSteps.class);


    @Before
    public void putScenarioNameToMDCContextMap(Scenario scenario) {
        String scenarioName = scenario.getName();
//        MDC.put("scenarioName", scenarioName);  Comment out, to have scenario name as part of MDC context
        log.info("Scenario \"" + scenarioName + "\" started");
    }

}
