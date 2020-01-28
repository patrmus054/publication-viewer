package com.example.inzynieria

import android.content.Context
import androidx.multidex.MultiDex
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class ApplicationCore: DaggerApplication(){

    private lateinit var androidInjector: AndroidInjector<out DaggerApplication>

    override fun onCreate() {
        super.onCreate()

        // Initialize Stetho
        Stetho.initializeWithDefaults(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)

       // androidInjector = DaggerAppComponent.builder().application(this).build()
    }

    public override fun applicationInjector(): AndroidInjector<out DaggerApplication> = androidInjector

}