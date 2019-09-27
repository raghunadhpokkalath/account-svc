package com.anz.wd.accounts.exception

import spock.lang.Specification

class GlobalExceptionHandlerSpec extends Specification {

    def handler
    def setup(){
        handler = new GlobalExceptionHandler()

    }
    def "Testing Record NotFound"() {
       given:
       def exception = new RecordNotFoundException("No accounts for the customer")
       def expResp = new ExceptionResponse("No accounts for the customer")

        when:
        def result = handler.handleNotFound(exception)

        then:
        result.message == expResp.message

    }
}
