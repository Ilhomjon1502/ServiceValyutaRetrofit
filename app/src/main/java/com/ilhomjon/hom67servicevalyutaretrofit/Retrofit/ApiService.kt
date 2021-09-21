package com.ilhomjon.hom67servicevalyutaretrofit.Retrofit

import com.ilhomjon.hom67servicevalyutaretrofit.DbRoom.Entity.Valyuta
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("json")
    fun getUsers(): Call<List<Valyuta>>
}