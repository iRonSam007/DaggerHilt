package com.example.daggerhilttuto.data.repo

import android.app.Application
import com.example.daggerhilttuto.R
import com.example.daggerhilttuto.data.remote.MyApi
import com.example.daggerhilttuto.domain.repo.MyRepo
import javax.inject.Inject

class MyRepoImpl @Inject constructor(
    private val api: MyApi,
    private val appContext: Application
): MyRepo {

    init{
        val appName = appContext.getString(R.string.app_name)
        println("issam, Repo/viewmodel, checking app name $appName")
    }

    override suspend fun doNetworkCall(){
    }
}