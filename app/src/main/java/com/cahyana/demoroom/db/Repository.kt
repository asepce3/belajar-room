package com.cahyana.demoroom.db

import androidx.lifecycle.LiveData
import com.cahyana.demoroom.db.room.entity.Book

class Repository(private val localDataSource: LocalDataSource) {

    fun save(books: List<Book>) {
        localDataSource.save(books)
    }

    fun save(book: Book) {
        localDataSource.save(book)
    }

    fun update(books: List<Book>) {
        localDataSource.update(books)
    }

    fun update(book: Book) {
        localDataSource.update(book)
    }

    fun delete(books: List<Book>) {
        localDataSource.delete(books)
    }

    fun delete(book: Book) {
        localDataSource.delete(book)
    }

    fun getAll(): LiveData<List<Book>> {
        return localDataSource.getAll()
    }

    fun find(title: String): LiveData<List<Book>> =
        localDataSource.find(title)
}