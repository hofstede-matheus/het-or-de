package com.hofstedematheus.hetorde.core

import android.text.Editable
import android.text.TextWatcher
import com.mancj.materialsearchbar.MaterialSearchBar
import kotlinx.coroutines.*

fun MaterialSearchBar.onChange(callBack: () -> Unit) {
    val DEBOUNCE_PERIOD: Long = 500

    this.addTextChangeListener(object : TextWatcher {
        var debounceJob: Job? = null
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            debounceJob?.cancel()
            debounceJob = CoroutineScope(Dispatchers.Main).launch {
                delay(DEBOUNCE_PERIOD)
                callBack()
            }
        }
    })
}
