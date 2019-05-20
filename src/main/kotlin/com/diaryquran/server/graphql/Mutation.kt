package com.diaryquran.server.graphql

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.diaryquran.server.dao.UserDao
import com.diaryquran.server.model.input.RegisterUser
import org.springframework.stereotype.Component

@Component
class Mutation(private val userDao: UserDao): GraphQLMutationResolver {
    // create user
    fun userCreate(input: RegisterUser) = userDao.createUser(input)
}