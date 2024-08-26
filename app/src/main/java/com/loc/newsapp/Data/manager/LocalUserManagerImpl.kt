package com.loc.newsapp.Data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.loc.newsapp.Util.Constants
import com.loc.newsapp.Util.Constants.USER_SETTINGS
import com.loc.newsapp.domain.manager.LocalUSerManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserManagerImpl(
    private val context: Context,


):LocalUSerManager {
    override suspend fun saveAppEntry() {
       context.dataStore.edit{
           settings ->
           settings[PreferenceKeys.AppEntry]=true


       }



    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map{
            preferences->
            preferences[PreferenceKeys.AppEntry]?:false

        }


    }
}


private val Context.dataStore :DataStore<Preferences> by preferencesDataStore(name =USER_SETTINGS)

private object PreferenceKeys{
    val AppEntry = booleanPreferencesKey(name = Constants.APP_ENTRY)

}