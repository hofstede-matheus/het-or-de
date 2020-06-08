package com.hofstedematheus.hetorde.data.repository

interface DutchArticleRepository {
    suspend fun getArticle(word: String): String
}