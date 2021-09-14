package com.eduvy.demo.viewmodelimpl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eduvy.demo.base.BaseViewModel
import com.eduvy.demo.base.StatefulResource
import com.eduvy.demo.data.model.CoursesModel
import com.eduvy.demo.data.repo.repoimpl.RepoHomeImpl
import com.eduvy.demo.utils.SessionManager
import com.eduvy.demo.viewmodel.ViewmodelCourses
import com.eduvy.demo.viewmodel.ViewmodelHomePage

class ViewmodelCoursesImpl(
    private val mRepoHomeImpl: RepoHomeImpl,
    private val mSessionManager: SessionManager,
) : BaseViewModel(), ViewmodelCourses {

    init {
        getCourses()
    }

    override fun onRefresh(mRefreshString: String) {

    }

    override fun onNoNetWork(mString: String?) {

    }

    override fun getCourses() {
        launch {
            val res = mRepoHomeImpl.getCourses()
            passApiResponseToUiThread(res, mutableApiResponseCourses)
        }
    }

    private val mutableApiResponseCourses: MutableLiveData<StatefulResource<CoursesModel?>> =
        MutableLiveData()
    override val apiResponseCourses: LiveData<StatefulResource<CoursesModel?>>
        get() = mutableApiResponseCourses
}