package com.cahyana.demoroom.db

import com.cahyana.demoroom.AppExecutors
import com.cahyana.demoroom.db.room.entity.Book
import com.cahyana.demoroom.db.room.BookDao

class LocalDataSource(private val bookDao: BookDao, private val appExecutors: AppExecutors) : DataSource {

    override fun save(books: List<Book>) {
        appExecutors.diskIO().execute {
            bookDao.save(books)
        }
    }

    override fun save(book: Book) {
        appExecutors.diskIO().execute {
            bookDao.save(book)
        }
    }

    override fun update(books: List<Book>) {
        appExecutors.diskIO().execute {
            bookDao.update(books)
        }
    }

    override fun update(book: Book) {
        appExecutors.diskIO().execute {
            val id = bookDao.update(book)
            if (id < 1) {
                bookDao.save(book)
            }
        }
    }

    override fun delete(books: List<Book>) {
        appExecutors.diskIO().execute {
            bookDao.delete(books)
        }
    }

    override fun delete(book: Book) {
        appExecutors.diskIO().execute {
            bookDao.delete(book)
        }
    }

    override fun getAll() = bookDao.getAll()

    override fun find(title: String) = bookDao.find(title)
}