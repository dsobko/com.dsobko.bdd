package com.dsobko.test

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ContextConfiguration
import java.lang.annotation.Inherited


@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Inherited
@SpringBootTest
@ContextConfiguration(classes = arrayOf(com.dsobko.test.MainConfiguration::class))
@DirtiesContext
annotation class CucumberStep
