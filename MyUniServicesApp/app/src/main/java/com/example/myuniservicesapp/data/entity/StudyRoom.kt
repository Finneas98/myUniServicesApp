package com.example.myuniservicesapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "studyrooms")
data class StudyRoom (
    @PrimaryKey
    val roomId: Int,
    val roomName: String
)