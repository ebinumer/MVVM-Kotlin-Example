package com.eduvy.demo.data.api

import com.eduvy.demo.data.model.CoursesModel
import com.eduvy.demo.data.model.InstitutionModel
import com.eduvy.demo.utils.Constants
import com.eduvy.demo.utils.Constants.GET_COURSES
import com.eduvy.demo.utils.Constants.GET_INSTITUTION
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EduvyApi {

    @GET(GET_INSTITUTION)
    suspend fun getInstitution(
    ): Response<InstitutionModel>

    @GET(GET_COURSES)
    suspend fun getCourses(
    ): Response<CoursesModel>
}