package com.eduvy.demo.data.repo.repoimpl

import com.eduvy.demo.data.api.EduvyApi
import com.eduvy.demo.data.model.CoursesModel
import com.eduvy.demo.data.model.InstitutionModel
import com.eduvy.demo.data.repo.base.BaseRepository
import com.eduvy.demo.data.repo.base.Resource
import com.eduvy.demo.data.repo.helpers.DataFetchHelper
import com.eduvy.demo.data.repo.repos.RepoHome
import com.google.gson.Gson
import retrofit2.Response
import timber.log.Timber

class RepoHomeImpl(
    private val mApi: EduvyApi
) : BaseRepository(), RepoHome {
    override suspend fun getInstitution(): Resource<InstitutionModel?> {
        return object : DataFetchHelper.NetworkOnly<InstitutionModel?>(
            "getInstitution"
        ) {
            override suspend fun getDataFromNetwork(): Response<out Any?> {
                return mApi.getInstitution()
            }

            override suspend fun convertApiResponseToData(response: Response<out Any?>) =
                (response.body() as InstitutionModel)

            override suspend fun storeFreshDataToLocal(data: InstitutionModel?) = false

        }.fetchDataIOAsync().await()
    }

    override suspend fun getCourses(): Resource<CoursesModel?> {
        return object : DataFetchHelper.NetworkOnly<CoursesModel?>(
            "getCourses"
        ) {
            override suspend fun getDataFromNetwork(): Response<out Any?> {
                return mApi.getCourses()
            }

            override suspend fun convertApiResponseToData(response: Response<out Any?>) =
                (response.body() as CoursesModel)

            override suspend fun storeFreshDataToLocal(data: CoursesModel?) = false

        }.fetchDataIOAsync().await()
    }

}