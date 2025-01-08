package com.example.myuniservicesapp.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "bookings",
    foreignKeys = [
        ForeignKey(entity = Room::class, parentColumns = ["id"], childColumns = ["roomId"])
    ]
)
data class Booking(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val roomId: Int,
    val timeSlot: String,
    val date: String,
    val userId: String
)