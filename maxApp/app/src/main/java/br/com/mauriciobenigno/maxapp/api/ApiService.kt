package br.com.mauriciobenigno.maxapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiService {

    private var URL = "https://api.myjson.com/bins/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getEndPoints() : EndPoints{
        return getRetrofit().create(EndPoints::class.java)
    }
}