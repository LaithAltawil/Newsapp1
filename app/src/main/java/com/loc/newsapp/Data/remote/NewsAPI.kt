package com.loc.newsapp.Data.remote

import com.loc.newsapp.Data.remote.dto.NewsResposnse
import com.loc.newsapp.Util.Constants.APIKEY
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsAPI {
    @GET("everything")
    suspend fun getNews(
        @Query("page")page:Int,
        @Query("sources") sources:String,
        @Query("apiKey") apiKey:String=APIKEY
    ): NewsResposnse



}