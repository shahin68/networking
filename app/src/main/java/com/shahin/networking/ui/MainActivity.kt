package com.shahin.networking.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.shahin.networking.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.searchError.observe(this, Observer {
            message.text = it
        })

        mainViewModel.searchResults.observe(this, Observer { list ->
            val items = list.map { it.title }
            val stringBuilder = StringBuilder()
            items.forEach {
                stringBuilder.append("-")
                stringBuilder.append(it)
                stringBuilder.append('\n')
            }
            response.text = stringBuilder
        })

        button.setOnClickListener {
            message.text = ""
            mainViewModel.search(textInput.text.toString())
        }
    }
}