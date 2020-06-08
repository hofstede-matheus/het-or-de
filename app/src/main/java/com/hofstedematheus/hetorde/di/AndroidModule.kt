package com.hofstedematheus.hetorde.di

import com.hofstedematheus.hetorde.data.datasource.JsoupParserDataSource
import com.hofstedematheus.hetorde.data.repository.DutchArticleRepository
import com.hofstedematheus.hetorde.presentation.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
    single<DutchArticleRepository> { JsoupParserDataSource() }
    viewModel {
        MainViewModel(
            repository = get()
        )
    }

}