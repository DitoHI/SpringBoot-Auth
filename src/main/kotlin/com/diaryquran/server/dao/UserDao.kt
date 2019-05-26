package com.diaryquran.server.dao

import com.diaryquran.server.exception.CustomException
import com.diaryquran.server.model.User
import com.diaryquran.server.model.input.RegisterUser
import com.diaryquran.server.repository.UserRepository
import com.diaryquran.server.utils.CommonUtils
import com.diaryquran.server.utils.ResponseCode
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.ConstraintViolation
import javax.validation.Valid

@Component
class UserDao(private val userRepository: UserRepository) {
    fun createUser(@Valid @RequestBody registerUser: RegisterUser): User {
        // validator
        val violations: Set<ConstraintViolation<RegisterUser>> =
            CommonUtils.getValidator().validate(registerUser)

        // exception when there is violation
        if (violations.isNotEmpty()) {
            val violation = violations.iterator().next()
            throw CustomException(
                ResponseCode.badRequest().responseCode,
                "${violation.propertyPath} ${violation.message}"
            )
        }

        val newUser = User(
            username = registerUser.username,
            email = registerUser.email,
            password = registerUser.password,
            name = registerUser.name,
            age = registerUser.age,
            photo = registerUser.photo
        )

        // if name is not inputted,
        // then make name same with username
        newUser.name = registerUser.name ?: registerUser.username

        val registeredUser = userRepository.save(newUser)

        // create users in firebase
        // FirebaseUtils.createUser(registeredUser)

        return registeredUser
    }

    fun getUserByEmail(email: String) = userRepository.findByEmail(email)

    fun getUserByEmailAndPassword(email: String, password: String) =
        userRepository.findByEmailAndPassword(email, password)
}