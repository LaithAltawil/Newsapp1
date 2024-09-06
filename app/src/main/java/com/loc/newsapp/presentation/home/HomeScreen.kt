package com.loc.newsapp.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.paging.compose.LazyPagingItems
import com.loc.newsapp.domain.model.Article

@Composable
fun HomeScreen(
    articles: LazyPagingItems<Article>,
    navigate: (String) -> Unit
) {
    val titles by remember{ derivedStateOf {
        if (articles.itemCount > 10){
            articles.itemSnapshotList.items.slice(IntRange(start = 0, endInclusive = 9))
                .joinToString(separator = " \uD83d\uDFE5 ") { it.title }
        }else{
            ""
        }
    }}

}
