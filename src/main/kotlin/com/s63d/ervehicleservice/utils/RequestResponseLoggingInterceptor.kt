package com.s63d.ervehicleservice.utils

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;


class RequestResponseLoggingInterceptor : ClientHttpRequestInterceptor {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @Throws(IOException::class)
    override fun intercept(request: HttpRequest, body: ByteArray, execution: ClientHttpRequestExecution): ClientHttpResponse {
        logRequest(request, body)
        val response = execution.execute(request, body)
        logResponse(response)
        return response
    }

    @Throws(IOException::class)
    private fun logRequest(request: HttpRequest, body: ByteArray) {
        if (log.isDebugEnabled()) {
            log.debug("===========================request begin================================================")
            log.debug("URI         : {}", request.getURI())
            log.debug("Method      : {}", request.getMethod())
            log.debug("Headers     : {}", request.getHeaders())
            log.debug("Request body: {}", String(body, Charset.defaultCharset()))
            log.debug("==========================request end================================================")
        }
    }

    @Throws(IOException::class)
    private fun logResponse(response: ClientHttpResponse) {
        if (log.isDebugEnabled()) {
            log.debug("============================response begin==========================================")
            log.debug("Status code  : {}", response.getStatusCode())
            log.debug("Status text  : {}", response.getStatusText())
            log.debug("Headers      : {}", response.getHeaders())
            log.debug("Response body: {}", StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()))
            log.debug("=======================response end=================================================")
        }
    }
}