package com.cahyana.demoroom.db.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cahyana.demoroom.db.room.entity.Book

private const val DATABASE_NAME = "room_demo"

@Database(entities = [Book::class], version = 1)
abstract class BookDatabase : RoomDatabase() {

    abstract fun bookDao(): BookDao

    companion object {
        private var instance: BookDatabase? = null

        fun getInstance(context: Context): BookDatabase {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        Room.databaseBuilder(context.applicationContext,
                            BookDatabase::class.java,
                            DATABASE_NAME
                        )
                            .build().apply { instance = this }
                    }
                }
            }
            return instance as BookDatabase
        }
    }
}