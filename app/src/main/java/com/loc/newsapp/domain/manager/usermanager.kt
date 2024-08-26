package com.loc.newsapp.domain.manager

import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.Flow

interface LocalUSerManager{

    suspend fun saveAppEntry()

    fun readAppEntry(): Flow<Boolean>


}
