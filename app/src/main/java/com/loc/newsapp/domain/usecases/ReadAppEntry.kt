package com.loc.newsapp.domain.usecases

import com.loc.newsapp.domain.manager.LocalUSerManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry (
    private val localUSerManager: LocalUSerManager
    )
    {
         operator fun invoke(): Flow<Boolean> {
           return localUSerManager.readAppEntry()


        }
    }
