package com.example.myuniservicesapp.utils

import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

fun loginUser(
    email: String,
    password: String,
    onSuccess: () -> Unit,
    onError: (String) -> Unit
) {
    val auth = Firebase.auth
    // authenticates the user with email and password supplied in login form
    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                onSuccess()
            } else {
                onError(task.exception?.message ?: "An error occurred")
            }
        }
}

fun logoutUser() {
    val auth = Firebase.auth
    auth.signOut()
}

fun registerUser(
    email: String,
    password: String,
    name: String,
    onSuccess: () -> Unit,
    onError: (String) -> Unit
) {
    val auth = Firebase.auth
    // creates a new firebase user with the supplied email and password strings
    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // if successful creates a new user entity in firebase db,
                // this is done to store more details such as their name
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
    // Create a new user object
    val user = hashMapOf(
        "email" to email,
        "password" to password,
        "name" to name
    )

    val db = Firebase.firestore

    // Set the document ID to the userId
    db.collection("users")
        .document(userId)
        .set(user)
        .addOnSuccessListener {
            Log.d("Firestore", "User saved successfully with ID: $userId")
        }
        .addOnFailureListener { e ->
            Log.w("Firestore", "Error saving user", e)
        }
}


fun updateUserDetails(
    newName: String,
    currentPassword: String,
    newPassword: String,
    onSuccess: () -> Unit,
    onError: (String) -> Unit
) {
    try {
        val user = Firebase.auth.currentUser
        val db = Firebase.firestore

        if (user == null) {
            onError("User not logged in")
            return
        }

        // Reauthenticate the user with the current password
        val email = user.email
        if (email == null) {
            onError("User email not found")
            return
        }

        val credential = EmailAuthProvider.getCredential(email, currentPassword)
        user.reauthenticate(credential)
            .addOnCompleteListener { reauthTask ->
                if (reauthTask.isSuccessful) {
                    // Reauthentication successful, proceed with password update
                    user.updatePassword(newPassword)
                        .addOnCompleteListener { updatePasswordTask ->
                            if (updatePasswordTask.isSuccessful) {
                                // Update other user details
                                val updates = mapOf("name" to newName,"password" to newPassword)
                                db.collection("users").document(user.uid)
                                    .update(updates)
                                    .addOnSuccessListener { onSuccess() }
                                    .addOnFailureListener { e ->
                                        onError(e.message ?: "Error updating name")
                                    }
                            } else {
                                onError(updatePasswordTask.exception?.message ?: "Error updating password")
                            }
                        }
                } else {
                    // displays appropriate error message when the user inserts an incorrect currentPassword
                    // when attempting to update password
                    when (val exception = reauthTask.exception) {
                        is FirebaseAuthInvalidCredentialsException -> {
                            onError("The current password is incorrect.")
                        }
                        else -> {
                            onError(exception?.message ?: "Error reauthenticating user.")
                        }
                    }
                }
            }
    } catch (e: Exception) {
        onError(e.message ?: "Unexpected error occurred")
    }
}

fun fetchUserName(userId: String, onSuccess: (String) -> Unit, onError: (String) -> Unit) {
    val db = Firebase.firestore
    // fetches the current users name from 'users' table from firebase db
    db.collection("users")
        .document(userId)
        .get()
        .addOnSuccessListener { document ->
            if (document.exists()) {
                val name = document.getString("name") ?: "Unknown"
                onSuccess(name)
            } else {
                onError("User not found")
            }
        }
        .addOnFailureListener { exception ->
            onError(exception.message ?: "Error fetching user name")
        }
}




