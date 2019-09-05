package com.example.myjetpack.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myjetpack.viewmodel.ShoeModel
import com.example.myjetpack.db.repository.ShoeRepository

class ShoeModelFactory(private val repository: ShoeRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoeModel(repository) as T
    }
}