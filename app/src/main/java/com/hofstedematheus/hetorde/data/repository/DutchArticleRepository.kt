package com.hofstedematheus.hetorde.data.repository

interface DutchArticleRepository {
    fun getArticle(word: String): String
}