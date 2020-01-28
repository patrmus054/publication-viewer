package com.example.inzynieria.main.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase


//class AppDatabase private constructor(){
//
//    var magazineDAO = MagazineDAO()
//        private set
//
//    companion object{
//        @Volatile private var instace: AppDatabase? = null
//
//        fun getInstance() =
//            instace ?: synchronized(this){
//                instace ?: AppDatabase().also { instace = it }
//            }
//    }
//}

@Database(entities = [MagazineDAO::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun MagazineDAO(): MagazineDAO

    //abstract fun commentDao(): CommentDao
}