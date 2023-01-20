package com.example.test

import retrofit2.Call
import retrofit2.http.GET
interface RetrofitService {
    @GET("api/")
    fun getTileList():Call<Results>
}