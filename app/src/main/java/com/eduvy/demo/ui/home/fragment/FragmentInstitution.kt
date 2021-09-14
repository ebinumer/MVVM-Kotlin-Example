package com.eduvy.demo.ui.home.fragment

import com.eduvy.demo.R
import com.eduvy.demo.base.BaseFragmentMain
import com.eduvy.demo.data.model.InstitutionModelData
import com.eduvy.demo.databinding.FragmentInstitutionBinding
import com.eduvy.demo.ui.home.adapter.AdapterInstitute
import com.eduvy.demo.ui.home.adapter.OnInstituteClickListener
import com.eduvy.demo.viewmodelimpl.ViewmodelInstitutionImpl
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class FragmentInstitution :
    BaseFragmentMain<FragmentInstitutionBinding, ViewmodelInstitutionImpl>() {
    private val mViewmodelGet by viewModel<ViewmodelInstitutionImpl>()
    override val mViewModel: ViewmodelInstitutionImpl
        get() = mViewmodelGet

    val onInstituteClickListener = object : OnInstituteClickListener {
        override fun onInstituteClickListener(mData: InstitutionModelData, position: Int) {}
    }
    private var mAdapterInstitute: AdapterInstitute = AdapterInstitute(onInstituteClickListener)

    override fun getLayoutResId(): Int = R.layout.fragment_institution

    override fun init() {
        observeItems()
        initUI()
    }

    private fun initUI() {
        getViewDataBinding().apply {
            recyclerInstitut.adapter = mAdapterInstitute
        }

    }

    private fun observeItems() {
        with(getViewModelObject()) {
            apiResponseInstitution.observe(viewLifecycleOwner, { stateFulResponse ->
                if (stateFulResponse.isSuccessful() && stateFulResponse.hasData()) {
                    stateFulResponse.getData()?.let { institutionModel ->
                        if (institutionModel.status == "SUCCESS") {
                            Timber.e("courses = ${institutionModel}")
                            mAdapterInstitute.setListItem(institutionModel.data)
                        }

                    }
                } else {

                }
            })
        }
    }
}