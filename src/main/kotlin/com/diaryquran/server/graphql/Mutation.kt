package com.diaryquran.server.graphql

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.diaryquran.server.dao.UserDao
import com.diaryquran.server.model.input.RegisterUser
import org.springframework.stereotype.Component
import javax.validation.Valid

@Component
class Mutation(private val userDao: UserDao): GraphQLMutationResolver {
    // create user
    fun userCreate(@Valid input: RegisterUser) = userDao.createUser(input)
}