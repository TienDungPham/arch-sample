package com.tiendungpham.archsamples.ui.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tiendungpham.archsamples.databinding.FragmentScoreBinding

class ScoreFragment : Fragment() {
    lateinit var binding: FragmentScoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScoreBinding.inflate(inflater, container, false)
        return binding.root
    }
}