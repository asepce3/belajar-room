package com.cahyana.demoroom.db

import androidx.lifecycle.LiveData
import com.cahyana.demoroom.db.room.entity.Book

interface DataSource {

    fun save(books: List<Book>)

    fun save(book: Book)

    fun update(books: List<Book>)

    fun update(book: Book)

    fun delete(books: List<Book>)

    fun delete(book: Book)

    fun getAll(): LiveData<List<Book>>

    fun find(title: String): LiveData<List<Book>>
}