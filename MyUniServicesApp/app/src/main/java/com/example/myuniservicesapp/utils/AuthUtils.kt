package com.example.myuniservicesapp.utils

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore



fun loginUser(
    email: String,
    password: String,
    onSuccess: () -> Unit,
    onError: (String) -> Unit
) {
    val auth = Firebase.auth
    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                onSuccess()
            } else {
                onError(task.exception?.message ?: "An error occurred")
            }
        }
}

fun registerUser(email: String, password: String, name: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
    val auth = Firebase.auth
    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val userId = auth.currentUser?.uid
                if (userId != null) {
                    saveUserToFirestore(userId, email, password, name)
                }
                onSuccess()
            } else {
                onError(task.exception?.message ?: "An error occurred")
            }
        }
}

fun saveUserToFirestore(
    userId: String,
    email: String,
    password: String,
    name: String
) {
    // Create a new user with a first and last name
    val user = hashMapOf(
        "id" to userId,
        "email" to email,
        "password" to password,
        "name" to name
    )
    val db = Firebase.firestore

// Add a new document with a generated ID
    db.collection("users")
        .add(user)
        .addOnSuccessListener { documentReference ->
            Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
        }
        .addOnFailureListener { e ->
            Log.w(TAG, "Error adding document", e)
        }
}
