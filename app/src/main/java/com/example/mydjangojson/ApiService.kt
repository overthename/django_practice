package com.example.mydjangojson

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    companion object{
        public val API_URL = "http://192.168.0.12:8000/"
    }
    @GET("tests")
    fun get_tests(@Query("format") json:String): Call<List<hInfo>>
}