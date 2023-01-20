package com.example.test

import android.content.Context
import android.util.Log

import androidx.lifecycle.MutableLiveData
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback

object TitleRepository {

    fun getTitleList(context:Context): MutableLiveData<List<NameResponse>> {

        var mutableLiveData = MutableLiveData<List<NameResponse>>()
        APiClient.apiService.getTileList().enqueue(object : Callback<Results> {
            override fun onFailure(call: Call<Results>, t: Throwable) {
                Log.e("error", t.localizedMessage)
            }

            override fun onResponse(
                call: Call<Results>,
                response: Response<Results>
            ) {
                val titleResponse = response.body()?.results
                titleResponse?.let { mutableLiveData.value = it }
            }

        })

        return mutableLiveData
    }
}