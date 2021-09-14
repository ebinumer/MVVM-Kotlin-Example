package com.eduvy.demo.data.repo.repos

import com.eduvy.demo.data.model.CoursesModel
import com.eduvy.demo.data.model.InstitutionModel
import com.eduvy.demo.data.repo.base.Resource

interface RepoHome {
    suspend fun getInstitution(): Resource<InstitutionModel?>
    suspend fun getCourses(): Resource<CoursesModel?>
}