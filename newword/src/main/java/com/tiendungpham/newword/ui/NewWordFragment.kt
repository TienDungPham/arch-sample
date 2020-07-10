package com.tiendungpham.newword.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tiendungpham.archsamples.GuessWordApplication
import com.tiendungpham.core.data.Word
import com.tiendungpham.newword.dagger.DaggerNewWordComponent
import com.tiendungpham.newword.databinding.FragmentNewWordBinding
import javax.inject.Inject

class NewWordFragment : Fragment() {
    private lateinit var binding: FragmentNewWordBinding
    private lateinit var wordAdapter: WordAdapter

    @Inject
    lateinit var newWordViewModelFactory: NewWordViewModelFactory
    val newWordViewModel: NewWordViewModel by viewModels {
        newWordViewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerNewWordComponent.builder()
            .setCoreComponent(GuessWordApplication.coreComponent(this.requireContext())).build()
            .injectNewWord(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewWordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wordAdapter = WordAdapter(object : WordAdapterCallBack {
            override fun onDeleteWord(word: Word) {
                newWordViewModel.deleteWord(word)
            }
        })
        binding.wordRv.let {
            it.adapter = wordAdapter
            it.layoutManager = LinearLayoutManager(this.requireContext())
        }

        newWordViewModel.wordList.observe(viewLifecycleOwner, Observer {
            wordAdapter.submitList(it)
        })

        binding.addBtn.setOnClickListener {
            newWordViewModel.createWord(binding.inputWord.text.toString())
        }

        binding.resetBtn.setOnClickListener {
            binding.inputWord.text.clear()
        }
    }
}