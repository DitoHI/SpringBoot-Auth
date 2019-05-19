package com.diaryquran.server.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,

    @Column(name = "username")
    @field:NotNull(message = "Username cannot be Null")
    var username: String,

    @Column(name = "email")
    @field:NotNull(message = "Email cannot be Null")
    @field:Email
    var email: String = "",

    @Column(name = "password")
    @field:NotNull(message = "Password cannot be Null")
    var password: String = "",

    @Column(name = "name")
    var name: String = "",

    @Column(name = "age")
    var age: String = "",

    @Column(name = "photo")
    var photo: String = ""
)