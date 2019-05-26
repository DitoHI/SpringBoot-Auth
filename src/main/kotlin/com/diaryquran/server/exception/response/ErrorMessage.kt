package com.diaryquran.server.exception.response

import java.util.Date

data class ErrorMessage(
    var timestamp: Date = Date(),
    var message: String = ""
)