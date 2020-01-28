package com.example.inzynieria.main.data.repository

import com.example.inzynieria.main.data.local.room.MagazinesEntity
import com.example.inzynieria.main.di.qualifier.LocalData
import com.example.inzynieria.main.di.qualifier.RemoteData
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MagazineRepository @Inject constructor(
    @LocalData private val localDataSource: MagazineDataSource,
    @RemoteData private val remoteDataSource: MagazineDataSource
) : MagazineDataSource {

    private var cachedMagazines = listOf<MagazinesEntity>()

    private var cacheMagazinesIsDirty = false

    override fun getAllMagazines(): Flowable<List<MagazinesEntity>> {

        if (cachedMagazines.isNotEmpty() && !cacheMagazinesIsDirty) {
            return Flowable.just(cachedMagazines)
        }

        val remoteMagazine = getAndSaveRemoteMagazines()

        return if (cacheMagazinesIsDirty) remoteMagazine else {
            val localMagazines = getAndCacheLocalMagazines()
            Flowable.concat(localMagazines, remoteMagazine)
        }
    }

    override fun saveAllMagazines(news: List<MagazinesEntity>) {
        localDataSource.saveAllMagazines(news)
        remoteDataSource.saveAllMagazines(news)
    }

    override fun refreshMagazines() {
        cacheMagazinesIsDirty = true
    }

    private fun getAndSaveRemoteMagazines(): Flowable<List<MagazinesEntity>> {
        return remoteDataSource.getAllMagazines()
            .doOnNext { magazine ->
                localDataSource.saveAllMagazines(magazine)
                cachedMagazines = magazine
            }.doOnComplete {
                cacheMagazinesIsDirty = false
            }
    }

    private fun getAndCacheLocalMagazines(): Flowable<List<MagazinesEntity>> {
        return localDataSource.getAllMagazines().doOnNext { magazine -> cachedMagazines = magazine }
    }

    //private var cachedComments: MutableMap<Int, List<CommentEntity>> = mutableMapOf()

    //private var cacheCommentsIsDirty = false



//    override fun getAllComments(newsId: Int): Flowable<List<CommentEntity>> {
//        cachedComments[newsId]?.let { comments ->
//            if (comments.isNotEmpty() && !cacheCommentsIsDirty) {
//                return Flowable.just(comments)
//            }
//        }
//
//        val remoteComments = getAndSaveRemoteComments(newsId)
//
//        return if (cacheCommentsIsDirty) remoteComments else {
//            val localComments = getAndCacheLocalComments(newsId)
//            Flowable.concat(localComments, remoteComments)
//        }
//    }



//    override fun saveAllComments(comments: List<CommentEntity>) {
//        localDataSource.saveAllComments(comments)
//        remoteDataSource.saveAllComments(comments)
//    }


//    override fun refreshComments() {
//        cacheCommentsIsDirty = true
//    }





//    private fun getAndSaveRemoteComments(newsId: Int): Flowable<List<CommentEntity>> {
//        return remoteDataSource.getAllComments(newsId)
//            .doOnNext { comments ->
//                localDataSource.saveAllComments(comments)
//                cachedComments[newsId] = comments
//            }.doOnComplete {
//                cacheCommentsIsDirty = false
//            }
//    }
//
//    private fun getAndCacheLocalComments(newsId: Int): Flowable<List<CommentEntity>> {
//        return localDataSource.getAllComments(newsId).doOnNext { comments -> cachedComments[newsId] = comments }
//    }
}