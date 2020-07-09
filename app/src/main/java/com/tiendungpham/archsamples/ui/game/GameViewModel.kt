package com.tiendungpham.archsamples.ui.game

import androidx.lifecycle.*
import com.tiendungpham.core.data.Word
import com.tiendungpham.core.data.source.WordRepository

class GameViewModel(private val wordRepository: WordRepository) : ViewModel() {
    private val _wordList = liveData<List<Word>> {
        val words = wordRepository.getAllWordAsList()
        emit(words)
    }
    private lateinit var wordList: MutableList<Word>
    private val wordListObserver = Observer<List<Word>> {
        wordList = it.toMutableList()
        if (it.isEmpty()) {
            _gameFinished.value = true
        } else {
            _currentWord.value = wordList.removeAt(0)
        }
    }

    private val _currentWord = MutableLiveData<Word>()
    val currentWord: LiveData<Word>
        get() {
            return _currentWord
        }

    private val _totalScore = MutableLiveData<Int>()
    val totalScore: LiveData<Int>
        get() {
            return _totalScore
        }

    private val _gameFinished = MutableLiveData<Boolean>()
    val gameFinished: LiveData<Boolean>
        get() {
            return _gameFinished
        }

    init {
        _totalScore.value = 0
        _gameFinished.value = false
        _wordList.observeForever(wordListObserver)
    }

    override fun onCleared() {
        _wordList.removeObserver(wordListObserver)
    }

    fun onNextWord() {
        _totalScore.value = (_totalScore.value)?.plus(1)
        if (wordList.isEmpty()) {
            _gameFinished.value = true
        } else {
            _currentWord.value = wordList.removeAt(0)
        }
    }

    fun onSkipWord() {
        if (wordList.isEmpty()) {
            _gameFinished.value = true
        } else {
            _currentWord.value = wordList.removeAt(0)
        }
    }
}