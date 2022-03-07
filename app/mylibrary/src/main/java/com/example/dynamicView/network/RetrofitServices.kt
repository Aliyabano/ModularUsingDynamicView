package com.example.dynamicView.network

import com.example.modularusingdynamicview.model.Response.RandomCocktailResponse
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface RetrofitServices {

    companion object {
        const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"

    }
    @POST("list.php")
    suspend fun categoryList(@Query("c")list:String): Response<RandomCocktailResponse>


}