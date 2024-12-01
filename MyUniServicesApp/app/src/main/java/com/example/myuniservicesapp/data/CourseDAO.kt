package com.example.myuniservicesapp.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDAO {

    @Query("SELECT * from courses WHERE id = :id")
    fun getItem(id: Int): Flow<Course>

    @Query("SELECT * from courses ORDER BY courseName ASC")
    fun getAllItems(): Flow<List<Course>>
}