package com.dsobko.test

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.restassured.RestAssured
import io.restassured.config.HttpClientConfig
import io.restassured.config.ObjectMapperConfig
import io.restassured.mapper.factory.Jackson2ObjectMapperFactory
import org.slf4j.LoggerFactory.getLogger
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration


@Configuration
@ComponentScan(basePackages = arrayOf("com.dsobko.test"))
@EnableAutoConfiguration
@EnableConfigurationProperties
class MainConfiguration : CommandLineRunner {

    private val log = getLogger(this.javaClass)

    @Throws(Exception::class)
    override fun run(vararg args: String) {
        configureRestAssured()
        log.info("RestAssured client configured successfully")
    }

    private fun configureRestAssured() {
            val objectMapperFactory = Jackson2ObjectMapperFactory { _: Class<*>?, _: String? ->
            val mapper = ObjectMapper()
            mapper.registerModule(JavaTimeModule())
            mapper.registerModule(KotlinModule())
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
            mapper
        }
        RestAssured.reset()
        RestAssured.config = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("CONNECTION_MANAGER_TIMEOUT", 5L))
                .objectMapperConfig(ObjectMapperConfig.objectMapperConfig().jackson2ObjectMapperFactory(objectMapperFactory))
//                .logConfig(LogConfig.logConfig().defaultStream(LoggerPrintStreamExtractor(log).printStream))
    }

}
