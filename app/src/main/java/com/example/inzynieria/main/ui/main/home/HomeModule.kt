package com.example.inzynieria.main.ui.main.home

import com.example.inzynieria.main.di.FragmentScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): HomeFragment
}