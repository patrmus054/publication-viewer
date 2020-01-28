package com.example.inzynieria.main.di.module

import com.example.inzynieria.main.di.ActivityScoped
import com.example.inzynieria.main.ui.main.home.HomeModule
import com.example.inzynieria.main.ui.main.home.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [HomeModule::class])
    internal abstract fun bindMainActivity(): MainActivity

//    @ActivityScoped
//    @ContributesAndroidInjector(modules = [CommentModule::class])
//    internal abstract fun bindCommentActivity(): CommentActivity
}