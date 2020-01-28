package com.example.inzynieria.main.data.remote

import com.example.inzynieria.main.data.local.room.MagazinesEntity
import com.example.inzynieria.main.data.repository.MagazineDataSource
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MagazineRemoteDataSource @Inject constructor(
    private val magazineService: MagazineService
):MagazineDataSource{


    override fun getAllMagazines(): Flowable<List<MagazinesEntity>> {
        return magazineService.getTopMagazinesIds()
            .flatMap { magazinesIds ->
                Flowable.fromIterable(magazinesIds)
                    .take(10)
                    .flatMap { newsId ->
                        magazineService.getMagazines(newsId)
                    }.toList().toFlowable()
            }
    }

    override fun saveAllMagazines(news: List<MagazinesEntity>) {
    }

    override fun refreshMagazines() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

//    override fun getAllComments(newsId: Int): Flowable<List<CommentEntity>> {
//        return newsService.getNews(newsId)
//            .flatMap { news ->
//                Flowable.fromIterable(news.commentIds)
//                    .take(10)
//                    .flatMap { commentId ->
//                        newsService.getComment(commentId)
//                    }.toList().toFlowable()
//            }
//    }


//
//    override fun saveAllComments(comments: List<CommentEntity>) {
//    }


//
//    override fun refreshComments() {
//    }

//    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Result<T> {
//        try {
//            val response = call()
//            if (response.isSuccessful) {
//                val body = response.body()
//                if (body != null) return Result.success(
//                    body
//                )
//            }
//            return error(" ${response.code()} ${response.message()}")
//        } catch (e: Exception) {
//            return error(e.message ?: e.toString())
//        }
//    }
//
//    private fun <T> error(message: String): Result<T> {
//        Timber.e(message)
//        return Result.error("Network call has failed for a following reason: $message")
//    }

}
