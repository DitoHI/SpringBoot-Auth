package com.diaryquran.server.dao

import com.diaryquran.server.model.User
import com.diaryquran.server.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class UserDao(private val userRepository: UserRepository) {
    fun createUser(
        username: String,
        email: String,
        password: String,
        name: String?,
        age: String?,
        photo: String?
    ): User {
        val newUser = User(
            username = username,
            email = email,
            password = password,
            name = name,
            age = age,
            photo = photo
        )
        return userRepository.save(newUser)
    }

    fun getUserByEmail(email: String) = userRepository.findByEmail(email)

    fun getUserByEmailAndPassword(email: String, password: String) =
        userRepository.findByEmailAndPassword(email, password)
}