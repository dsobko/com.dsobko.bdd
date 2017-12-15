package com.dsobko.test.steps

import com.dsobko.test.CucumberStep
import cucumber.api.java.en.Given
import org.springframework.beans.factory.annotation.Autowired


@CucumberStep
class TestSteps(@Autowired private val testService: TestService) {

    @Given("^test request is formed$")
    fun testRequestFormed() {
        testService.formTestRequest()
    }

}
