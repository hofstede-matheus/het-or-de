package com.hofstedematheus.hetorde.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.hofstedematheus.hetorde.R
import com.hofstedematheus.hetorde.core.Constants
import com.hofstedematheus.hetorde.core.onChange
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupAds()
        setupViewModel()
        setupListeners()

    }

    private fun setupAds() {
//        adView.adUnitId = Constants.ADMOB_FOOTER_BANNER_AD_ID
        MobileAds.initialize(this) {}

        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
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
