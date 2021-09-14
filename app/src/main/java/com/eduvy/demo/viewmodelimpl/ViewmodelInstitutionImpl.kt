package com.eduvy.demo.viewmodelimpl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eduvy.demo.base.BaseViewModel
import com.eduvy.demo.base.StatefulResource
import com.eduvy.demo.data.model.InstitutionModel
import com.eduvy.demo.data.repo.repoimpl.RepoHomeImpl
import com.eduvy.demo.utils.SessionManager
import com.eduvy.demo.viewmodel.ViewmodelInstitution

class ViewmodelInstitutionImpl (
    private val mRepoHomeImpl: RepoHomeImpl,
    private val mSessionManager: SessionManager,
) : BaseViewModel(), ViewmodelInstitution {

    init {
        getInstitution()
    }
    override fun onRefresh(mRefreshString: String) {

    }

    override fun onNoNetWork(mString: String?) {

    }

    override fun getInstitution() {
        launch {
            val res = mRepoHomeImpl.getInstitution()
            passApiResponseToUiThread(res, mutableApiResponseInstitution)
        }
    }
    private val mutableApiResponseInstitution: MutableLiveData<StatefulResource<InstitutionModel?>> =
        MutableLiveData()
    override val apiResponseInstitution: LiveData<StatefulResource<InstitutionModel?>>
        get() = mutableApiResponseInstitution
}