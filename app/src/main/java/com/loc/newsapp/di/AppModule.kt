package com.loc.newsapp.di

import android.app.Application
import com.loc.newsapp.Data.manager.LocalUserManagerImpl
import com.loc.newsapp.domain.manager.LocalUSerManager
import com.loc.newsapp.domain.usecases.AppEntry.AppEntryUseCases
import com.loc.newsapp.domain.usecases.AppEntry.ReadAppEntry
import com.loc.newsapp.domain.usecases.AppEntry.SaveAppEntry
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
    fun provideAppEntryUseCases(
        LocalUSerManager: LocalUSerManager
    )= AppEntryUseCases(
        readAppEntry = ReadAppEntry(LocalUSerManager),
        saveAppEntry = SaveAppEntry(LocalUSerManager)


    )

}