package com.dwiki.wordapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dwiki.wordapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = getString(R.string.str_title_appbar)

        setupFragment()
    }

    private fun setupFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container,ListAlphabetFragment())
            .commit()
    }
}