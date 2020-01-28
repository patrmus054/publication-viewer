package com.example.inzynieria.main.data.repository

import com.example.inzynieria.main.data.local.room.MagazinesEntity
import io.reactivex.Flowable

interface MagazineDataSource {
    fun getAllMagazines(): Flowable<List<MagazinesEntity>>

    //fun getAllComments(newsId: Int): Flowable<List<CommentEntity>>

    fun saveAllMagazines(magazines: List<MagazinesEntity>)

    //fun saveAllComments(comments: List<CommentEntity>)

    fun refreshMagazines()

    //fun refreshComments()
}