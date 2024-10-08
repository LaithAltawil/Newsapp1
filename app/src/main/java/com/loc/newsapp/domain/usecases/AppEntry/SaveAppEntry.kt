package com.loc.newsapp.domain.usecases.AppEntry

import com.loc.newsapp.domain.manager.LocalUSerManager

class SaveAppEntry(
    private val localUSerManager: LocalUSerManager
) {

    suspend operator fun invoke(){
        localUSerManager.saveAppEntry()



    }
}