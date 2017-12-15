package com.dsobko.test.assertions

import org.fest.assertions.AssertExtension
import org.fest.assertions.api.Assertions.assertThat


class TestAssertion(val expectedResponse: Any, val actualResponse: Any) : AssertExtension {

    fun assertReconciliationReportHeader(): TestAssertion {
        assertThat(actualResponse).isNotNull
        return this
    }


}