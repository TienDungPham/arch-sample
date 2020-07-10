package com.tiendungpham.newword.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tiendungpham.core.data.Word
import com.tiendungpham.newword.databinding.WordItemBinding

class WordAdapter(private val wordAdapterCallBack: WordAdapterCallBack) :
    ListAdapter<Word, WordAdapter.WordViewHolder>(WordDiffUtilsCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder =
        WordViewHolder.create(parent)

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(getItem(position), wordAdapterCallBack)
    }

    class WordViewHolder(private val binding: WordItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(word: Word, wordAdapterCallBack: WordAdapterCallBack) {
            binding.wordItem.text = word.title
            binding.wordItemDelete.setOnClickListener {
                wordAdapterCallBack.onDeleteWord(word)
            }
        }

        companion object {
            fun create(parent: ViewGroup): WordViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                return WordViewHolder(WordItemBinding.inflate(inflater, parent, false))
            }
        }
    }
}

class WordDiffUtilsCallBack : DiffUtil.ItemCallback<Word>() {
    override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem.title == newItem.title
    }

}

interface WordAdapterCallBack {
    fun onDeleteWord(word: Word)
}