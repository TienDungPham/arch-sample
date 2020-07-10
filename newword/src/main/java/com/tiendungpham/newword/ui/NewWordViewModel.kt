package com.tiendungpham.newword.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.tiendungpham.core.data.Word
import com.tiendungpham.core.data.source.WordRepository
import kotlinx.coroutines.launch
import java.util.*

class NewWordViewModel(private val wordRepository: WordRepository) : ViewModel() {
    val wordList: LiveData<List<Word>> = wordRepository.getAllWord().asLiveData()

    fun createWord(title: String) {
        viewModelScope.launch {
            val newWord = Word(UUID.randomUUID().toString(), title)
            wordRepository.createWord(newWord)
        }
    }

    fun deleteWord(word: Word) {
        viewModelScope.launch {
            wordRepository.deleteWord(word)
        }
    }
}