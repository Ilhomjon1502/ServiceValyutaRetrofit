package com.ilhomjon.hom67servicevalyutaretrofit.Service

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.ilhomjon.hom67servicevalyutaretrofit.DbRoom.Database.AppDatabase
import com.ilhomjon.hom67servicevalyutaretrofit.DbRoom.Entity.Valyuta
import com.ilhomjon.hom67servicevalyutaretrofit.Retrofit.ApiClient
import com.ilhomjon.hom67servicevalyutaretrofit.Retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpLoadWork(val context: Context, workerParameters: WorkerParameters)
    : Worker(context, workerParameters){
    lateinit var appDatabase: AppDatabase
    private val TAG = "UpLoadWork"
    override fun doWork(): Result {

        getUsers()

        return Result.success()
    }

    private fun getUsers() {

        appDatabase = AppDatabase.getInstance(context)

        ApiClient.getRetrofit().create(ApiService::class.java)
            .getUsers().enqueue(object : Callback<List<Valyuta>>{
                override fun onResponse(
                    call: Call<List<Valyuta>>,
                    response: Response<List<Valyuta>>
                ) {
                    if (response.isSuccessful){
                        val body = response.body()

                        val d = ArrayList<Valyuta>()
                        d.addAll(appDatabase.valyutaDao().getAllNews())

                        body?.forEach {
                            if (d.isEmpty()){
                                appDatabase.valyutaDao().addNews(it)
                            }else{
                                appDatabase.valyutaDao().updateNew(it)
                            }
                            Log.d(TAG, "onResponse: $it")
                            Toast.makeText(context, "$it", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                override fun onFailure(call: Call<List<Valyuta>>, t: Throwable) {

                }
            })
    }

}