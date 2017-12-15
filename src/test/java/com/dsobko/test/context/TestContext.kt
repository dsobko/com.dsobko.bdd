package com.dsobko.test.context

import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.BigDecimal.valueOf


@Service
class TestContext {

    var currency: String = "EUR"
    var txAmount: BigDecimal = valueOf(10.0)
}