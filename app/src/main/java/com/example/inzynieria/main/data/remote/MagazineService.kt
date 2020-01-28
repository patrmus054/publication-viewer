package com.example.inzynieria.main.data.remote

import com.example.inzynieria.main.data.local.room.MagazinesEntity
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface   MagazineService {

//    @GET("lego/themes/")
//    suspend fun getThemes(@Query("page") page: Int? = null,
//                          @Query("page_size") pageSize: Int? = null,
//                          @Query("ordering") order: String? = null): Response<ResultsResponse<Magazine>>
//
//    @GET("lego/sets/")
//    suspend fun getSets(@Query("page") page: Int? = null,
//                        @Query("page_size") pageSize: Int? = null,
//                        @Query("theme_id") themeId: Int? = null,
//                        @Query("ordering") order: String? = null): Response<ResultsResponse<Magazine>>

//    @GET("lego/sets/{id}/")
//    suspend fun getSet(@Path("id") id: String): Response<MagazinesEntity>

    @GET("/magazines/ids/")
    fun getTopMagazinesIds(): Flowable<List<String>>

    @GET("/magazines/{_id}")
    fun getMagazines(@Path("_id") newsId: String): Flowable<MagazinesEntity>

}