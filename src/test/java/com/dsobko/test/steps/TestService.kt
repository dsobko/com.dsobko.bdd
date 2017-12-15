package com.dsobko.test.steps

import com.dsobko.test.props.TestServerConfigs
import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.apache.http.HttpStatus
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class TestService(private val testServerConfigs: TestServerConfigs) {

    private val log = LoggerFactory.getLogger(this.javaClass)

    fun formTestRequest() {
        log.info("Sending test request")

        RestAssured.given()
                .log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 123")
                .request()
                .post(testServerConfigs.testRequestUrl())
                .then()
                .log().all()
                .and()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .extract()
    }
}