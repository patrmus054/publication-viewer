package com.example.inzynieria.main.data

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api.php")
    fun hitCountCheck(@Query("action") action: String,
                      @Query("format") format: String,
                      @Query("list") list: String,
                      @Query("srsearch") srsearch: String)
}