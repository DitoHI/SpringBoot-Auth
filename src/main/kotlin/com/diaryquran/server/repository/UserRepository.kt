package com.diaryquran.server.repository

import com.diaryquran.server.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: CrudRepository<User, Long> {
    fun findByEmail(email: String): User?
    fun findByEmailAndPassword(email: String, password: String): User?
}