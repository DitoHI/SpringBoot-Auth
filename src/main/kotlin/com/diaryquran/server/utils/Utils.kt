package com.diaryquran.server.utils

import com.diaryquran.server.model.User
import com.google.firebase.auth.ActionCodeSettings
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserRecord
import javax.validation.Validation
import javax.validation.Validator

class CommonUtils {
    companion object {
        fun getValidator(): Validator {
            val factory = Validation.buildDefaultValidatorFactory()
            return factory.validator
        }
    }
}

class FirebaseUtils {
    companion object {
        fun setActionCodeSetting(): ActionCodeSettings {
            return ActionCodeSettings.builder().build()
        }

        fun createUser(user: User) {
            val request = UserRecord.CreateRequest()
                .setUid(user.id.toString())
                .setEmail(user.email)
                .setEmailVerified(false)
                .setPassword(user.password)
                .setDisplayName(user.username)
                .setEmailVerified(false)
                .setDisabled(false)

            if (!user.photo.isNullOrBlank()) {
                request.setPhotoUrl(user.photo)
            }

            FirebaseAuth.getInstance().createUser(request)
        }
    }
}