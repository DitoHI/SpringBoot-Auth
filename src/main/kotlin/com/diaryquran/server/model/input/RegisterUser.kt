package com.diaryquran.server.model.input

import com.fasterxml.jackson.annotation.JsonRootName
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@JsonRootName("users")
data class RegisterUser(
    @NotNull(message = "can't be missing")
    @Size(min = 1, message = "can't be empty")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$", message="must be a valid email")
    var email: String,

    @NotNull(message = "can't be missing")
    @Size(min = 1, message = "can't be empty")
    var password: String,

    @NotNull(message = "can't be missing")
    var username: String,

    var name: String?,

    var age: Int?,

    var photo: String?
)