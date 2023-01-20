package com.example.test

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TitleViewModel(private val context:Context):ViewModel() {

    private var listData= MutableLiveData<List<NameResponse>>()

    fun getTitleList(): MutableLiveData<List<NameResponse>>{
        listData = TitleRepository.getTitleList(context)
        return listData

    }
}