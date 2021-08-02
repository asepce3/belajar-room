package com.cahyana.demoroom.db.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.cahyana.demoroom.db.room.entity.Book

@Dao
interface BookDao {

    @Query("SELECT * FROM books")
    fun getAll(): LiveData<List<Book>>

    @Query("SELECT * FROM books WHERE title LIKE :title")
    fun find(title: String): LiveData<List<Book>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(book: Book)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(books: List<Book>)

    @Update
    fun update(book: Book): Int

    @Update
    fun update(books: List<Book>)

    @Delete
    fun delete(book: Book)

    @Delete
    fun delete(books: List<Book>)
}