package com.diaryquran.server.service

import com.diaryquran.server.model.User
import com.diaryquran.server.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {
    val currentUser = ThreadLocal<User>()

    fun clearCurrentUser() = currentUser.remove()

    fun setCurrentUser(user: User): User {
        currentUser.set(user)
        return user
    }

    fun currentUser() = currentUser.get()
}