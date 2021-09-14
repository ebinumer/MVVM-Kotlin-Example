package com.eduvy.demo.viewmodel

import androidx.lifecycle.LiveData
import com.eduvy.demo.base.StatefulResource
import com.eduvy.demo.data.model.CoursesModel

interface ViewmodelCourses {

    fun getCourses()
    val apiResponseCourses: LiveData<StatefulResource<CoursesModel?>>
}