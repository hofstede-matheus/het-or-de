package com.hofstedematheus.hetorde.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.hofstedematheus.hetorde.R
import com.hofstedematheus.hetorde.core.onChange
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
        setupListeners()

    }

    private fun setupViewModel() {
        viewModel.noun.observe(
            this,
            Observer { noun ->
                answerTXT.text = noun
            }
        )
    }

    private fun setupListeners() {
        searchBar.onChange {
            viewModel.getArticle(searchBar.text)
        }
    }
}
