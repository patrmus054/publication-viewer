package com.example.inzynieria.main.di.module

import android.app.Application
import android.content.Context
import com.example.inzynieria.ApplicationCore
import com.example.inzynieria.main.di.qualifier.ApplicationContext
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    @ApplicationContext
    abstract fun bindApplicationContext(application: ApplicationCore): Context

    @Binds
    abstract fun bindApplication(application: ApplicationCore): Application
}