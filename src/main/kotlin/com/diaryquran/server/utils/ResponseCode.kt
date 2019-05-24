package com.diaryquran.server.utils

data class response_code(val responseCode: Int, val responseMessage: String)

class ResponseCode {
    companion object {
        fun badRequest() = response_code(400, "Bad Request")
    }
}