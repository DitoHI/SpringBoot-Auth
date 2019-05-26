package com.diaryquran.server.dao

import com.diaryquran.server.exception.CustomException
import com.diaryquran.server.model.User
import com.diaryquran.server.model.input.RegisterUser
import com.diaryquran.server.repository.UserRepository
import com.diaryquran.server.utils.CommonUtils
import com.diaryquran.server.utils.FirebaseUtils
import com.diaryquran.server.utils.ResponseCode
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component
import javax.validation.ConstraintViolation

@Component
class UserDao(private val userRepository: UserRepository) {
    fun createUser(registerUser: RegisterUser): User {
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
            name = registerUser.name,
            age = registerUser.age,
            password = registerUser.password,
            photo = registerUser.photo
        )

        // hash the password
        val encoder = BCryptPasswordEncoder(10)
        val userWithHashPassword = newUser.copy()
        userWithHashPassword.password = encoder.encode(userWithHashPassword.password)

        // if name is not inputted,
        // then make name same with username
        userWithHashPassword.name = registerUser.name ?: registerUser.username

        val userResult = userRepository.save(userWithHashPassword)

        // create users in firebase
        FirebaseUtils.createUser(newUser)
        return userResult
    }

    fun getUserByEmail(email: String) = userRepository.findByEmail(email)

    fun getUserByEmailAndPassword(email: String, password: String) =
        userRepository.findByEmailAndPassword(email, password)
}