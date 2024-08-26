package com.loc.newsapp.di

import android.app.Application
import com.loc.newsapp.Data.manager.LocalUserManagerImpl
import com.loc.newsapp.domain.manager.LocalUSerManager
import com.loc.newsapp.domain.usecases.AppEntryUseCases
import com.loc.newsapp.domain.usecases.ReadAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUSerManager(
        application: Application
    ):LocalUSerManager= LocalUserManagerImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases()=AppEntryUseCases(
        //TODO: ADD USE CASES

    )

}