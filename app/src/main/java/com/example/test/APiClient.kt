package com.example.test

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APiClient {
    private const val BASE_URL: String="https://randomuser.me/"

    private val gson:
            Gson by lazy{
        GsonBuilder().setLenient().create()
    }
    private val httpclient : OkHttpClient by lazy{
        OkHttpClient.Builder().build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpclient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val apiService : RetrofitService by lazy{
        retrofit.create(RetrofitService::class.java)
    }
}