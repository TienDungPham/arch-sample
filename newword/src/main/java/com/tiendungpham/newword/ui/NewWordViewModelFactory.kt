package com.tiendungpham.newword.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tiendungpham.core.data.source.WordRepository

class NewWordViewModelFactory(private val wordRepository: WordRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewWordViewModel::class.java)) {
            return NewWordViewModel(wordRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}