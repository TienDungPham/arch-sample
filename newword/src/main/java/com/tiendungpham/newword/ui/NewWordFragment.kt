package com.tiendungpham.newword.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tiendungpham.newword.databinding.FragmentNewWordBinding

class NewWordFragment : Fragment() {
    lateinit var binding: FragmentNewWordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewWordBinding.inflate(inflater, container, false)
        return binding.root
    }
}