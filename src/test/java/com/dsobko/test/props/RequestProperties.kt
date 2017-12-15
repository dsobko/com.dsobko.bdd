package com.dsobko.test.props

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration


@Configuration
@ConfigurationProperties(prefix = "request.properties")
class RequestProperties {

    lateinit var user: String
    lateinit var secret: String
}