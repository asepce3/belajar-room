package com.cahyana.demoroom.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.cahyana.demoroom.Injection
import com.cahyana.demoroom.databinding.ActivityMainBinding
import com.cahyana.demoroom.db.room.entity.Book

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = Injection.provideViewModelFactory(Injection.provideRepository(this))
        val viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        viewModel.getBook().observe(this, {
            if (it.isNotEmpty()) {
                binding.tvTitle.text = it[0].title
                binding.tvAuthor.text = it[0].author
            }
        })

        binding.btnSave.setOnClickListener {
            val title = binding.etTitle.text.toString()
            val author = binding.etAuthor.text.toString()
            viewModel.updateBook(Book(1, title, author))
        }
    }
}