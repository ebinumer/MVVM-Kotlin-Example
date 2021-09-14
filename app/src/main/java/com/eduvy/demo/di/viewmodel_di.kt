package com.eduvy.demo.di

import com.eduvy.demo.viewmodelimpl.ViewmodelCoursesImpl
import com.eduvy.demo.viewmodelimpl.ViewmodelHomeImpl
import com.eduvy.demo.viewmodelimpl.ViewmodelInstitutionImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mViewmodel = module {

    viewModel {
        ViewmodelHomeImpl(get(),get())
    }
    viewModel {
        ViewmodelInstitutionImpl(get(),get())
    }
    viewModel {
        ViewmodelCoursesImpl(get(),get())
    }
}