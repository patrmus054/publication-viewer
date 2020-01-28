package com.example.inzynieria.main.data.local

import com.example.inzynieria.main.data.local.room.MagazineDAO
import com.example.inzynieria.main.data.local.room.MagazinesEntity
import com.example.inzynieria.main.data.repository.MagazineDataSource
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MagazineLocalDataSource @Inject constructor(
    private val magazineDAO: MagazineDAO
    //private val commentDao: CommentDao
) : MagazineDataSource {

    override fun getAllMagazines(): Flowable<List<MagazinesEntity>> {
        return magazineDAO.getAllMagazines().toFlowable()
    }

    override fun saveAllMagazines(magazines: List<MagazinesEntity>) {
        magazines.map{ magazineDAO.insertMagazines(it)}
    }

    override fun refreshMagazines() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}