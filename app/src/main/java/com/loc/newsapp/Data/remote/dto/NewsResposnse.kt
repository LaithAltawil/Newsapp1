package com.loc.newsapp.Data.remote.dto

import com.loc.newsapp.domain.model.Article

data class NewsResposnse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)