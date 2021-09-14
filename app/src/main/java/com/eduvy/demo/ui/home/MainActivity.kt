package com.eduvy.demo.ui.home

import com.eduvy.demo.R
import com.eduvy.demo.base.BaseActivity
import com.eduvy.demo.databinding.ActivityMainBinding
import com.eduvy.demo.ui.home.adapter.ViewPagerAdapter
import com.eduvy.demo.viewmodelimpl.ViewmodelHomeImpl
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, ViewmodelHomeImpl>() {
    private val mViewmodelGet by viewModel<ViewmodelHomeImpl>()
    lateinit var viewpageradapter: ViewPagerAdapter
    override val mViewModel: ViewmodelHomeImpl
        get() = mViewmodelGet

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun init() {
        viewpageradapter= ViewPagerAdapter(supportFragmentManager)
        getViewDataBinding().apply {
            viewPager.adapter = viewpageradapter
            tabs.setupWithViewPager(viewPager)
        }
    }
}