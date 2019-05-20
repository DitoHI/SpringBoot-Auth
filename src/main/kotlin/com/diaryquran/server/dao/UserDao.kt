package com.diaryquran.server.dao

import com.diaryquran.server.model.User
import com.diaryquran.server.model.input.RegisterUser
import com.diaryquran.server.repository.UserRepository
import com.diaryquran.server.utils.FirebaseUtils
import org.springframework.stereotype.Component

@Component
class UserDao(private val userRepository: UserRepository) {
    fun createUser(registerUser: RegisterUser): User {
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
        registerUser.name ?: run {
            newUser.name = registerUser.username
        }

        val registeredUser = userRepository.save(newUser)

        // create users in firebase
        FirebaseUtils.createUser(registeredUser)

        return registeredUser
    }

    fun getUserByEmail(email: String) = userRepository.findByEmail(email)

    fun getUserByEmailAndPassword(email: String, password: String) =
        userRepository.findByEmailAndPassword(email, password)
}