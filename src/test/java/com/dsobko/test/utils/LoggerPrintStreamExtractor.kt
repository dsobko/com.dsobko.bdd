package com.dsobko.test.utils

import org.slf4j.Logger
import java.io.IOException
import java.io.OutputStream
import java.io.PrintStream

class LoggerPrintStreamExtractor (private val logger: Logger) {

    private var printStream: PrintStream? = null

    fun getPrintStream(): PrintStream {
        if (printStream == null) {
            val output = object : OutputStream() {
                private var myStringBuilder = StringBuilder()

                @Throws(IOException::class)
                override fun write(b: Int) {
                    this.myStringBuilder.append(b.toChar())
                }

                override fun flush() {
                    logger.info(this.myStringBuilder.toString())
                    myStringBuilder = StringBuilder()
                }
            }

            printStream = PrintStream(output, true)
        }
        return printStream as PrintStream
    }
}