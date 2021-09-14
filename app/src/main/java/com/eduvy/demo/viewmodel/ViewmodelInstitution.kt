package com.eduvy.demo.viewmodel

import androidx.lifecycle.LiveData
import com.eduvy.demo.base.StatefulResource
import com.eduvy.demo.data.model.CoursesModel
import com.eduvy.demo.data.model.InstitutionModel

interface ViewmodelInstitution {
    fun getInstitution()
    val apiResponseInstitution: LiveData<StatefulResource<InstitutionModel?>>
}