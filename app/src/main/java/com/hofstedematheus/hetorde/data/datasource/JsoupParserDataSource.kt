package com.hofstedematheus.hetorde.data.datasource

import com.hofstedematheus.hetorde.data.repository.DutchArticleRepository
import org.jsoup.Jsoup

class JsoupParserDataSource: DutchArticleRepository {
    override fun getArticle(word: String): String {
        val document = Jsoup.connect("https://www.welklidwoord.nl/"+word).get()
        return document.getElementById("content").select("h1").text().toString()
    }
}