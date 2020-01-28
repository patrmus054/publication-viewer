package com.example.inzynieria.main.di.module

import androidx.room.Room
import com.example.inzynieria.ApplicationCore
import com.example.inzynieria.main.data.local.room.AppDatabase
import com.example.inzynieria.main.data.local.room.MagazineDAO
import dagger.Provides
import javax.inject.Singleton

class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(application: ApplicationCore): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "mag.db").build()
    }

    @Singleton
    @Provides
    fun provideNewsDao(database: AppDatabase): MagazineDAO = database.MagazineDAO()

//    @Singleton
//    @Provides
//    fun provideCommentDao(database: AppDatabase): CommentDao = database.commentDao()
}