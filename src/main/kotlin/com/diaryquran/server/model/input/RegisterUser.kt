package com.diaryquran.server.model.input

import com.fasterxml.jackson.annotation.JsonRootName
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@JsonRootName("users")
class RegisterUser {
    @NotNull(message = "can't be missing")
    @Size(min = 1, message = "can't be empty")
    @Email(message = "must be a valid email")
    var email: String = ""

    @NotNull(message = "can't be missing")
    @Pattern(
        regexp = "^(?=.*[0-9]+.*)(?=.*[a-zA-Z]+.*)[0-9a-zA-Z]{6,}\$",
        message = "must contain at least one letter, at least one number, and be longer than five charaters"
    )
    var password: String = ""

    @NotNull(message = "can't be missing")
    var username: String = ""

    var name: String? = null

    var age: Int? = null

    var photo: String? = null
}