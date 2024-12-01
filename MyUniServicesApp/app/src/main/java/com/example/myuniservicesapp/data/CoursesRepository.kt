package com.example.myuniservicesapp.data

import kotlinx.coroutines.flow.Flow

interface CoursesRepository {

    fun getAllItemsStream(): Flow<List<Course>>

    fun getItemStream(id: Int): Flow<Course?>
}