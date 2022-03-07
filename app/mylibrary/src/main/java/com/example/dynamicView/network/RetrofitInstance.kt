package com.example.dynamicView.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitInstance {

    @Provides
    @Singleton
    fun providesInstance(): RetrofitServices {
        return Retrofit.Builder()
            .baseUrl(RetrofitServices.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitServices::class.java)
    }

}