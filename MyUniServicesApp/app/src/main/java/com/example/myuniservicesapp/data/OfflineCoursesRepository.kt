package com.example.myuniservicesapp.data

import kotlinx.coroutines.flow.Flow

class OfflineCoursesRepository(private val courseDAO: CourseDAO) : CoursesRepository {
    override fun getAllItemsStream(): Flow<List<Course>> = courseDAO.getAllItems()

    override fun getItemStream(id: Int): Flow<Course?> = courseDAO.getItem(id)
}