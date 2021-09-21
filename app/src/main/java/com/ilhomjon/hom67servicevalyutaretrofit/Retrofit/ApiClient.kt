package com.ilhomjon.hom67servicevalyutaretrofit.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    const val BASE_URL = " http://cbu.uz/uzc/arkhiv-kursov-valyut/"

    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }
}