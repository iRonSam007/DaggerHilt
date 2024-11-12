package com.example.daggerhilttuto.di

import android.app.Application
import com.example.daggerhilttuto.data.remote.MyApi
import com.example.daggerhilttuto.data.repo.MyRepoImpl
import com.example.daggerhilttuto.domain.repo.MyRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)   //This defines the lifecycle of the injected object: SingletonComponent, ActivityComponent, ViewModel, Retained, Service ...
object AppModule {

    //Implement how dagger will provide the instances
    @Provides       //Annotate as a dagger provide function
    @Singleton      //Annotate the scope of the injected objects: only 1 instance of MyApi will be injected every time needed
    fun provideApi(): MyApi {
        return Retrofit.Builder()
            .baseUrl("https://test.com")
            .build()
            .create(MyApi::class.java)
    }

    /*
    This will be replaced by bindMyRepository in DI Repository Module
    @Provides
    @Singleton
    fun provideMyRepo(
        api: MyApi,
        app: Application
    ): MyRepo{
        return MyRepoImpl(api, app)
    }
    */

    //Named annotation for instances that have the same type in DI module is needed, Dagger doesn't include the method name in dependency graph, hence the need of
    @Provides
    @Singleton
    @Named("hello1")
    fun provideString1() = "hello 1"

    @Provides
    @Singleton
    @Named("hello2")
    fun provideString2() = "hello 2"
}