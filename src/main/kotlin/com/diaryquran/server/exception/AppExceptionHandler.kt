package com.diaryquran.server.exception

import com.diaryquran.server.exception.response.ErrorMessage
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class AppExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [(Exception::class)])
    fun handleAnyException(ex: Exception, request: WebRequest): ResponseEntity<ErrorMessage> {
        var errorMessageText = ex.localizedMessage

        if (errorMessageText.isNullOrEmpty()) errorMessageText = ex.toString()

        val errorMessage = ErrorMessage(message = errorMessageText)

        return ResponseEntity(errorMessage, HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR)
    }
}