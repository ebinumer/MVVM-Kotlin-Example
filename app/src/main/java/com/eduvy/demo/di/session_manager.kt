package com.eduvy.demo.di

import com.eduvy.demo.utils.SessionManager
import org.koin.dsl.module

val mSessionManager = module {
    single {
        SessionManager(get())
    }
}