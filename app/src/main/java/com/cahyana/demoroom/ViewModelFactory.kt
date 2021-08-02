package com.cahyana.demoroom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cahyana.demoroom.db.Repository
import com.cahyana.demoroom.ui.main.MainViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Unknow ViewModel class")
        }
    }
}