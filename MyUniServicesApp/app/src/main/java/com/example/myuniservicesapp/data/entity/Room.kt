package com.example.myuniservicesapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rooms")
data class Room (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val roomName: String
)