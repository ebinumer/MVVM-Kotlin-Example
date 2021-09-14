package com.eduvy.demo.viewmodelimpl

import com.eduvy.demo.base.BaseViewModel
import com.eduvy.demo.data.repo.repoimpl.RepoHomeImpl
import com.eduvy.demo.utils.SessionManager
import com.eduvy.demo.viewmodel.ViewmodelHomePage

class ViewmodelHomeImpl(
    private val mRepoHomeImpl: RepoHomeImpl,
    private val mSessionManager: SessionManager,
) : BaseViewModel(), ViewmodelHomePage {

    override fun onRefresh(mRefreshString: String) {

    }

    override fun onNoNetWork(mString: String?) {

    }
}