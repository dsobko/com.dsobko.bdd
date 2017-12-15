package com.dsobko.test.props

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration


@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "test.server")
class TestServerConfigs {

    lateinit var host: String
    lateinit var accountUrl: String

    fun testRequestUrl() = "$host$accountUrl"
}