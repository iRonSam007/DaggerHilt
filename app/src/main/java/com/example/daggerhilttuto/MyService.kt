package com.example.daggerhilttuto

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import com.example.daggerhilttuto.domain.repo.MyRepo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MyService: Service(){
    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    @Inject
    lateinit var repository: MyRepo
    override fun onCreate() {
        super.onCreate()
        println("sam, Service created")
        serviceScope.launch {
            while(isActive){
                //val repoData = repository.methooodX() from injected repo
                Toast.makeText(applicationContext, "Service running", Toast.LENGTH_LONG).show()
                delay(5000L)
            }
        }
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel()
    }
}
