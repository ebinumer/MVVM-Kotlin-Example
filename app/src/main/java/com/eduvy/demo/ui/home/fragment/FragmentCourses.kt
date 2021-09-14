package com.eduvy.demo.ui.home.fragment

import com.eduvy.demo.R
import com.eduvy.demo.base.BaseFragmentMain
import com.eduvy.demo.data.model.CoursesModelData
import com.eduvy.demo.databinding.FragmentCoursesBinding
import com.eduvy.demo.ui.home.adapter.AdapterCourse
import com.eduvy.demo.ui.home.adapter.OnCourseClickListener
import com.eduvy.demo.viewmodelimpl.ViewmodelCoursesImpl
import com.google.gson.Gson
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class FragmentCourses : BaseFragmentMain<FragmentCoursesBinding, ViewmodelCoursesImpl>() {
    private val mViewmodelGet by viewModel<ViewmodelCoursesImpl>()
    override val mViewModel: ViewmodelCoursesImpl
        get() = mViewmodelGet

    override fun getLayoutResId(): Int = R.layout.fragment_courses

    val onCourseClickListener = object : OnCourseClickListener {
        override fun onCourseClickListener(mData: CoursesModelData, position: Int) {}
    }
    private var mAdapterCategory: AdapterCourse = AdapterCourse(onCourseClickListener)

    override fun init() {
        observeItems()
        initUI()
    }

    private fun initUI() {
        getViewDataBinding().apply {
            recyclerCourses.adapter = mAdapterCategory
        }
    }

    private fun observeItems() {
        with(getViewModelObject()) {
            apiResponseCourses.observe(viewLifecycleOwner, { stateFulResponse ->
                if (stateFulResponse.isSuccessful() && stateFulResponse.hasData()) {
                    stateFulResponse.getData()?.let { coursesModel ->
                        if (coursesModel.status == "SUCCESS") {
                            Timber.e("courses = ${coursesModel}")
                            mAdapterCategory.setListItem(coursesModel.data)
                        }

                    }
                } else {

                }
            })
        }
    }
}