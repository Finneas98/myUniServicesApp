package com.example.myuniservicesapp.utils

import android.content.ContentValues.TAG
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
    // Create a new user object
    val user = hashMapOf(
        "email" to email,
        "password" to password, // Note: Consider hashing the password instead of storing it in plain text
        "name" to name
    )

    val db = Firebase.firestore

    // Set the document ID to the userId
    db.collection("users")
        .document(userId)
        .set(user) // Use set() to specify the document ID explicitly
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
                    val exception = reauthTask.exception
                    when (exception) {
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

    db.collection("users")
        .document(userId) // Assuming the document ID is the same as the user ID
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




