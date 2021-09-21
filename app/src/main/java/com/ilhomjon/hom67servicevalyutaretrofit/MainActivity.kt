package com.ilhomjon.hom67servicevalyutaretrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.ilhomjon.hom67servicevalyutaretrofit.Service.UpLoadWork
import com.ilhomjon.hom67servicevalyutaretrofit.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConnect.setOnClickListener {
            val workRequest : WorkRequest = PeriodicWorkRequestBuilder<UpLoadWork>(15, TimeUnit.MINUTES)
                .build()
            WorkManager.getInstance(this).enqueue(workRequest)
        }
    }
}