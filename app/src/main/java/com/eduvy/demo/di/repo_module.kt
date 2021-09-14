package com.eduvy.demo.di

import com.eduvy.demo.data.repo.repoimpl.RepoHomeImpl
import org.koin.dsl.module

val repo = module {
    factory { RepoHomeImpl(get()) }
}