package com.diaryquran.server.utils

import com.diaryquran.server.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserRecord

class FirebaseUtils {
    companion object {
        fun createUser(user: User) {
            val request = UserRecord.CreateRequest()
                .setUid(user.id.toString())
                .setEmail(user.email)
                .setEmailVerified(false)
                .setPassword(user.password)
                .setDisplayName(user.username)
                .setDisabled(false)

            if (!user.photo.isNullOrBlank()) {
                request.setPhotoUrl(user.photo)
            }

            FirebaseAuth.getInstance().createUser(request)
        }
    }
}