package com.example.test

data class TitleResponse (val title:String,val first:String,val last:String)

data class NameResponse (val name: TitleResponse )

data class Results (val results: List<NameResponse>)
