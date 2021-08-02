package com.cahyana.demoroom

import android.content.Context
import com.cahyana.demoroom.db.room.BookDatabase
import com.cahyana.demoroom.db.LocalDataSource
import com.cahyana.demoroom.db.Repository

object Injection {

    private fun getDataSource(context: Context): LocalDataSource {
        val db = BookDatabase.getInstance(context)
        return LocalDataSource(db.bookDao(), AppExecutors())
    }

    fun provideRepository(context: Context): Repository {
        return Repository(getDataSource(context))
    }

    fun provideViewModelFactory(repository: Repository): ViewModelFactory {
        return ViewModelFactory(repository)
    }
}