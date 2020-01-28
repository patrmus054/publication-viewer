package com.example.inzynieria.main.data.local.room

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable
import io.reactivex.Maybe

interface MagazineDAO {
//    private val magazineList = mutableListOf<MagazinesEntity>()
//    private val magazines = MutableLiveData<List<MagazinesEntity>>()
//
//    init {
//        magazines.value = magazineList
//    }
//
//    fun addMagazine(magazine: MagazinesEntity){
//        magazineList.add(magazine)
//        magazines.value = magazineList
//    }
//
//    fun getMagazines() = magazines as LiveData<List<MagazinesEntity>>

    @Query("SELECT * FROM Magazines ORDER BY title ASC")
    fun getAllMagazines(): Maybe<List<MagazinesEntity>>

    @Query("SELECT * FROM Magazines WHERE id = :magazinesId")
    fun getMagazineById(magazinesId: Int): Flowable<MagazinesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMagazines(magazine: MagazinesEntity)
}

//@Dao
//interface MagazineDAO {
//
//    @Query("SELECT * FROM themes ORDER BY id DESC")
//    fun getMagazines(): LiveData<List<Magazine>>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertAll(plants: List<Magazine>)
//}