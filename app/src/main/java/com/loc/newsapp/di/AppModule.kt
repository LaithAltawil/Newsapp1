package com.loc.newsapp.di

import android.app.Application
import com.loc.newsapp.Data.Repository.NewsRepositoryImpl
import com.loc.newsapp.Data.manager.LocalUserManagerImpl
import com.loc.newsapp.Data.remote.NewsAPI
import com.loc.newsapp.Util.Constants.BASE_URL
import com.loc.newsapp.domain.manager.LocalUSerManager
import com.loc.newsapp.domain.repository.NewsRepository
import com.loc.newsapp.domain.usecases.AppEntry.AppEntryUseCases
import com.loc.newsapp.domain.usecases.AppEntry.ReadAppEntry
import com.loc.newsapp.domain.usecases.AppEntry.SaveAppEntry
import com.loc.newsapp.domain.usecases.news.GetNews
import com.loc.newsapp.domain.usecases.news.NewsUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUSerManager(
        application: Application
    ): LocalUSerManager = LocalUserManagerImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        LocalUSerManager: LocalUSerManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(LocalUSerManager),
        saveAppEntry = SaveAppEntry(LocalUSerManager)


    )

    @Provides
    @Singleton
    fun provideNewAPI():NewsAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(newsAPI: NewsAPI): NewsRepository = NewsRepositoryImpl(newsAPI)




    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository)
        )
    }
}