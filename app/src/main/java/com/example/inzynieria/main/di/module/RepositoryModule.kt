package com.example.inzynieria.main.di.module

import com.example.inzynieria.main.data.local.MagazineLocalDataSource
import com.example.inzynieria.main.data.remote.MagazineRemoteDataSource
import com.example.inzynieria.main.data.repository.MagazineDataSource
import com.example.inzynieria.main.di.qualifier.LocalData
import com.example.inzynieria.main.di.qualifier.RemoteData
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    @LocalData
    abstract fun bindMagazinesLocalDataSource(newsLocalDataSource: MagazineLocalDataSource): MagazineDataSource


    @Singleton
    @Binds
    @RemoteData
    abstract fun bindMagazinesRemoteDataSource(newsRemoteDataSource: MagazineRemoteDataSource): MagazineDataSource
}