package com.diaryquran.server.model

import com.fasterxml.jackson.annotation.JsonRootName
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity
@JsonRootName("users")
@Table(name = "users", uniqueConstraints = [(UniqueConstraint(columnNames = ["username", "email"]))])
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,

    @Column(name = "username")
    var username: String,

    @Column(name = "email")
    var email: String,

    @Column(name = "password")
    var password: String,

    @Column(name = "name")
    var name: String? = "",

    @Column(name = "age")
    var age: Int? = null,

    @Column(name = "photo")
    var photo: String? = ""
)