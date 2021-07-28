package com.example.mydjangojson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)

        button1.setOnClickListener {
            fetchDjango_Json()

        }
    }

    fun fetchDjango_Json() {
        var retrofit = Retrofit.Builder().baseUrl(ApiService.API_URL).addConverterFactory(GsonConverterFactory.create()).build()
        var apiService = retrofit.create(ApiService::class.java)
        var tests = apiService.get_tests("json")
        tests.enqueue(object : Callback<List<hInfo>> {
            override fun onResponse(call: Call<List<hInfo>>, response: Response<List<hInfo>>) {
                if (response.isSuccessful) {
                    var mList = response.body()!!

                    runOnUiThread{
                        recyclerView.adapter = hInfoAdapter(mList)

                    }
                }
            }

            override fun onFailure(call: Call<List<hInfo>>, t: Throwable) {
                Log.e("D_tests", "OnFailuer+${t.message}")
            }
        }

        )
    }
}