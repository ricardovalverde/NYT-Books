package com.example.nytbooks.presentation.base

import androidx.appcompat.app.AppCompatActivity
import com.example.nytbooks.R

open class BaseActivity : AppCompatActivity() {
    protected fun setupToolbar(
        toolbar: androidx.appcompat.widget.Toolbar,
        title: Int,
        showBackButton: Boolean = false
    ) {

        toolbar.title = getString(title)
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(showBackButton)
    }

}