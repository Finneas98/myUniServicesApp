package com.example.myuniservicesapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rooms")
data class Room (
    @PrimaryKey
    val id: Int,
    val roomName: String
)