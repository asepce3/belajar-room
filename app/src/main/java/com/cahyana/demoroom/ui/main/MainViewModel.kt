package com.cahyana.demoroom.ui.main

import androidx.lifecycle.ViewModel
import com.cahyana.demoroom.db.Repository
import com.cahyana.demoroom.db.room.entity.Book

class MainViewModel(private val repository: Repository): ViewModel() {

    fun getBook() = repository.getAll()

    fun updateBook(book: Book) {
        repository.update(book)
    }
}