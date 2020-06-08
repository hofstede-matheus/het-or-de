package com.hofstedematheus.hetorde.data.datasource

import com.hofstedematheus.hetorde.data.repository.DutchArticleRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import org.jsoup.Jsoup

class JsoupParserDataSource : DutchArticleRepository {
    override suspend fun getArticle(word: String): String {
        val result = crawlAndGetWordAsync(word).await()
        return if(result.contains("De of het")) "Unfortunately, we are not that smart yet. Is this word a noun?"
        else result
    }

    private fun crawlAndGetWordAsync(
        word: String
    ): Deferred<String> = CoroutineScope(IO).async {
        val document = Jsoup.connect("https://www.welklidwoord.nl/" + word).get()
        return@async document.getElementById("content").select("h1").text().toString()
    }
}