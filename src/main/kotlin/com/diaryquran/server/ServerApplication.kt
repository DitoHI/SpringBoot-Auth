package com.diaryquran.server

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.io.FileInputStream

@SpringBootApplication
class ServerApplication

fun main(args: Array<String>) {
    initializeFirebase()
    runApplication<ServerApplication>(*args)
}

fun initializeFirebase() {
    val serviceAccount =
        FileInputStream("src/main/resources/credentials/diary-quran-firebase-adminsdk-qged3-5b98634269.json")

    val options = FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .setDatabaseUrl("https://diary-quran.firebaseio.com")
        .build()

    FirebaseApp.initializeApp(options)
}
