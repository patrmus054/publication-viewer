package com.example.inzynieria.main.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.inzynieria.main.di.ViewModelKey
import com.example.inzynieria.main.ui.main.home.HomeViewModel
import com.example.inzynieria.main.utilities.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module(includes = [AppModule::class, RepositoryModule::class])
abstract class ViewModelModule {

    @Singleton
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

//    @Binds
//    @IntoMap
//    @ViewModelKey(CommentViewModel::class)
//    abstract fun bindCommentViewModel(viewModel: CommentViewModel): ViewModel
}