package com.example.myuniservicesapp.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "bookings",
    foreignKeys = [
        ForeignKey(
            entity = StudyRoom::class,
            parentColumns = ["roomId"],
            childColumns = ["roomId"]
        )
    ],
    indices = [Index(value = ["roomId"])]
)
data class Booking(
    @PrimaryKey(autoGenerate = true)
    val bookingId: Int,
    val roomId: Int,
    val timeSlot: String,
    val date: String,
    val userId: String
)